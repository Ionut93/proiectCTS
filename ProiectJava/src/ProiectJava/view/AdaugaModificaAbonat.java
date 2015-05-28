package ProiectJava.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import ProiectJava.dao.AbonatDao;
import ProiectJava.dao.TelefonDAO;
import ProiectJava.model.Abonat;
import ProiectJava.model.Telefon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JList;

import util.AbonatBuilder;

public class AdaugaModificaAbonat extends JFrame {

	private JPanel contentPane;
	private JTextField tfNume;
	private JTextField tFPrenume;
	private JTextField tFCNP;
	private JTextField tFTelefon;
	private Abonat abonat;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugaModificaAbonat frame = new AdaugaModificaAbonat(anchor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param idAbonat 
	 */
	public AdaugaModificaAbonat( final Object idAbonat) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nume");
		lblNewLabel_1.setBounds(386, 53, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenume");
		lblNewLabel_2.setBounds(386, 93, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CNP");
		lblNewLabel_3.setBounds(386, 134, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfNume = new JTextField();
		tfNume.setColumns(10);
		tfNume.setBounds(254, 50, 109, 20);
		contentPane.add(tfNume);
		
		tFPrenume = new JTextField();
		tFPrenume.setColumns(10);
		tFPrenume.setBounds(254, 90, 109, 20);
		contentPane.add(tFPrenume);
		
		tFCNP = new JTextField();
		tFCNP.setColumns(10);
		tFCNP.setBounds(254, 131, 109, 20);
		contentPane.add(tFCNP);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(idAbonat==null){
				
				//nou.setId(Integer.parseInt(tFId.getText()));
			//	nou.setCnp(tFCNP.getText());
			//	nou.setNume(tfNume.getText());
			//	nou.setPrenume(tFPrenume.getText());
			//	nou.setListaTelefoane(listaTelefoane);
			//	nou.setListaTelefoane(listaTelefoane)
				
				Telefon tel = new Telefon();
				//tel.setId_abonat(nou.getId());
				tel.setNumar(tFTelefon.getText());
			//	tel.setTip(0);
			//	TelefonDAO.insert(tel);
			//	nou.setListaTelefoane(tel);
				Abonat nou = new AbonatBuilder().adaugaCnp(tFCNP.getText()).adaugaNume(tfNume.getText())
						.adaugaPrenume(tFPrenume.getText()).adaugaTelefon(tel).build();
				AbonatDao.insert(nou);
				//nou.setListaTelefoane(tel);
				
				
			}
			else{
				Abonat modificat = AbonatDao.getAbonatById(idAbonat);
				
				modificat.setCnp(tFCNP.getText());
				modificat.setNume(tfNume.getText());
				modificat.setPrenume(tFPrenume.getText());
				List<Telefon> tel = TelefonDAO.getAbonatByIdAbonat(idAbonat);
				tel.get(0).setNumar(tFTelefon.getText());
				modificat.setListaTelefoane(tel.get(0));
				
				
			
			//	nou.setListaTelefoane(listaTelefoane);
				AbonatDao.update(modificat);
			}
				
			dispose();
		}
		});
		btnOk.setBounds(69, 193, 91, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(249, 193, 91, 23);
		contentPane.add(btnCancel);
		
		tFTelefon = new JTextField();
		tFTelefon.setBounds(46, 49, 91, 23);
		contentPane.add(tFTelefon);
		tFTelefon.setColumns(10);
		if(idAbonat != null){
			List<Telefon> tel = TelefonDAO.getAbonatByIdAbonat(idAbonat);
			abonat = AbonatDao.getAbonatById(idAbonat);
			tfNume.setText(abonat.getNume());
			tFPrenume.setText(abonat.getPrenume());
			tFCNP.setText(abonat.getCnp());
			tFTelefon.setText(tel.get(0).getNumar());
		}
		
		
		JLabel lblNewLabel = new JLabel("Telefon");
		lblNewLabel.setBounds(69, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnMobile = new JRadioButton("Mobile");
		
		rdbtnMobile.setBounds(87, 158, 109, 23);
		contentPane.add(rdbtnMobile);
		
		JList list = new JList();
		list.setBounds(46, 93, 150, 55);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton.setBounds(147, 49, 46, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
