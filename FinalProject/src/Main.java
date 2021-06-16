import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class Main {

	private JFrame frame;
	private JTextField txtnama;
	private JTextField txtharga;
	private JTable table;
	
	ArrayList<Minuman> minumanList;
	DefaultTableModel dtm;
	String header[]= new String[] {"Nama Minuman", "Harga", "Jenis"};
	int row,col;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void displayMinuman() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for (int i=0; i < minumanList.size(); i++) {
			model.addRow(new Object[]{minumanList.get(i).namaminuman, minumanList.get(i).harga, minumanList.get(i).jenis});
	}
	}
	
	public void clearField() {
		txtnama.requestFocus();
		txtnama.setText("");
		txtharga.setText("");
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		initialize();
		minumanList=new ArrayList<>();
		dtm = new DefaultTableModel(header,0);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nama Minuman", "Harga", "Jenis"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(94);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 603, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data Minuman");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setBounds(257, 11, 140, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nama Minuman");
		lblNewLabel_1.setBounds(10, 31, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Harga");
		lblNewLabel_2.setBounds(10, 56, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtnama = new JTextField();
		txtnama.setBounds(109, 28, 468, 20);
		frame.getContentPane().add(txtnama);
		txtnama.setColumns(10);
		
		txtharga = new JTextField();
		txtharga.setBounds(109, 53, 86, 20);
		frame.getContentPane().add(txtharga);
		txtharga.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Jenis");
		lblNewLabel_3.setBounds(10, 81, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox combojenis = new JComboBox();
		combojenis.setBackground(Color.WHITE);
		combojenis.setModel(new DefaultComboBoxModel(new String[] {"Panas", "Dingin"}));
		combojenis.setBounds(109, 78, 86, 20);
		frame.getContentPane().add(combojenis);
		
		JButton btnTambah = new JButton("Tambah");
		btnTambah.setBackground(Color.WHITE);
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtnama.getText().equals("") || txtharga.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Mohon Isi Data Terlebih Dahulu");
				}
				else {
				String nm = txtnama.getText();
				int hg = Integer.parseInt(txtharga.getText());
				String jenis = (String) combojenis.getSelectedItem();
				minumanList.add(new Minuman(nm, jenis, hg));
				displayMinuman();
			}
				clearField();
			}
		});
		btnTambah.setBounds(10, 116, 89, 23);
		frame.getContentPane().add(btnTambah);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.setBackground(Color.WHITE);
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)
						table.getModel();
				int row = table.getSelectedRow();
				if (row >= 0) {
					int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin menghapus", "Konfirmasi", 
							JOptionPane.YES_NO_OPTION);
					if(ok==0) {
						model.removeRow(row);
					}
				}
			}
		});
		btnHapus.setBounds(109, 116, 89, 23);
		frame.getContentPane().add(btnHapus);
		
		JButton btnBersihkan = new JButton("Bersihkan");
		btnBersihkan.setBackground(Color.WHITE);
		btnBersihkan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtnama.setText("");
				txtharga.setText("");
			}
		});
		btnBersihkan.setBounds(377, 116, 101, 23);
		frame.getContentPane().add(btnBersihkan);
		
		JButton btnKeluar = new JButton("Keluar");
		btnKeluar.setBackground(Color.WHITE);
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnKeluar.setBounds(488, 116, 89, 23);
		frame.getContentPane().add(btnKeluar);
		
		JLabel lblNewLabel_4 = new JLabel("List Minuman");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(257, 150, 128, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 567, 259);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), null));
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
	}
}
