package ProiectJava.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import util.Caretaker;
import util.Memento;
import ProiectJava.dao.AbonatDao;
import ProiectJava.dao.TelefonDAO;
import ProiectJava.model.Abonat;
import ProiectJava.model.Telefon;

public class ListaAbonati extends JFrame {
	private JTable table;
	private JTextField textField;
	private DefaultTableModel model;
	private List<Abonat> list;
	private List<Telefon> listTel;
	private XTableColumnModel columnModel;
	private Caretaker caretaker = new Caretaker();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAbonati frame = new ListaAbonati();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaAbonati() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		model = new DefaultTableModel();
		Vector<Object> header = new Vector<Object>();

		header.add("Id");
		header.add("Nume");
		header.add("Prenume");
		header.add("CNP");
		header.add("Tel");
		model.setColumnIdentifiers(header);
		populate(0, "");

		textField = new JTextField();
		textField.setBounds(42, 25, 248, 19);
		textField.setColumns(10);

		final JRadioButton rdbtnNume = new JRadioButton("Nume");
		rdbtnNume.setBounds(42, 54, 67, 23);

		final JRadioButton rdbtnPrenume = new JRadioButton("Prenume");
		rdbtnPrenume.setBounds(125, 54, 91, 23);

		final JRadioButton rdbtnCnp = new JRadioButton("CNP");
		rdbtnCnp.setBounds(228, 54, 62, 23);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 418, 130);
		getContentPane().add(scrollPane);

		JButton btnCauta = new JButton("CAUTA");
		btnCauta.setBounds(308, 34, 91, 23);
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNume.isSelected()) {
					populate(1, textField.getText());
				} else if (rdbtnPrenume.isSelected()) {
					populate(2, textField.getText());
				} else if (rdbtnCnp.isSelected()) {
					populate(3, textField.getText());
				} else
					JOptionPane.showMessageDialog(null,
							"Trenuie sa selectaci un criteriu pentru cautare!");
			}
		});
		
		

		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.setBounds(5, 235, 80, 23);
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdaugaModificaAbonat adgAbonat = new AdaugaModificaAbonat(null);
				adgAbonat.show();
				// populate(0, "");

			}
		});
		
		

		JButton btnModifica = new JButton("Modifica");
		btnModifica.setBounds(90, 235, 85, 23);
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();

				if (row < 0) {
					JOptionPane
							.showMessageDialog(null,
									"Trebuie sa selectati un abonat pentru modificare!");
					return;
				}
				table.getValueAt(row, 1);
				Object idAbonat = table.getValueAt(row, 0);
				AdaugaModificaAbonat adgAbonat = new AdaugaModificaAbonat(
						idAbonat);
				adgAbonat.show();
				populate(0, "");

			}
		});

		JButton btnIesire = new JButton("Iesire");
		btnIesire.setBounds(360, 235, 80, 23);
		btnIesire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		columnModel = new XTableColumnModel();
		table.setColumnModel(columnModel);
		table.createDefaultColumnsFromModel();
		columnModel.setAllColumnsVisible();
		// TableColumn column = columnModel.getColumnByModelIndex(0);
		// columnModel.setColumnVisible(column, false);

		getContentPane().add(rdbtnNume);
		getContentPane().add(rdbtnPrenume);
		getContentPane().add(rdbtnCnp);
		getContentPane().add(btnAdauga);
		getContentPane().add(btnModifica);
		getContentPane().add(btnIesire);
		getContentPane().add(textField);
		getContentPane().add(btnCauta);

		JButton btnSterge = new JButton("Sterge");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(null,
							"Trebuie sa selectati un abonat pentru stergere!");
					return;
				}
				table.getValueAt(row, 1);
				Object idAbonat = table.getValueAt(row, 0);
				Abonat toDelete = AbonatDao.getAbonatById(idAbonat);
				TelefonDAO.delete(toDelete);
				AbonatDao.delete(toDelete);
				populate(0, "");
			}
		});
		btnSterge.setBounds(270, 235, 85, 23);
		getContentPane().add(btnSterge);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populate(0, "");
			}
		});
		btnRefresh.setBounds(308, 64, 91, 23);
		getContentPane().add(btnRefresh);
		
		JButton btnMemento = new JButton("Memento");
		btnMemento.setBounds(308, 04, 91, 23);
		btnMemento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				list = AbonatDao.loadPersoane(0, "");
				for ( Abonat element : list) {
					listTel = TelefonDAO.loadTelefonByAbonat(
							String.valueOf(element.getId()), 1);
					if(!listTel.isEmpty())
						element.setListaTelefoane(listTel.get(0));
				}
				caretaker.addSalvare(new Memento(list));
				
			}
		});
		getContentPane().add(btnMemento);
		
		JButton btnLoadMemento = new JButton("Reload");
		btnLoadMemento.setBounds(180, 235, 85, 23);
		getContentPane().add(btnLoadMemento);
		btnLoadMemento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Memento m = caretaker.getSalvare();
				if(m != null) {
					AbonatDao.deleteAll();
					List<Abonat> lista = m.getMemento();
					
					for(Abonat abonat : lista){
						AbonatDao.insert(abonat);
						
					}
					
					populate(0,"");
				}
				
			}
		});
	}
	
	

	private void populate(int crt, String valcrt) {
		list = AbonatDao.loadPersoane(crt, valcrt);
		model.setRowCount(0);

		for (Abonat element : list) {

			listTel = element.getListaTelefoane();
			String[] data = new String[5];
			data[0] = Integer.toString(element.getId());
			data[1] = element.getNume();
			data[2] = element.getPrenume();
			data[3] = element.getCnp();
			if (!listTel.isEmpty())
				data[4] = listTel.get(0).getNumar();
			else
				data[4] = "";

			model.addRow(data);
		}

	}
}
