package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Test extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public static MySqlAccess dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("root");
		createNodes(top);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 408, 109);
		contentPane.add(scrollPane);
		JTree tree = new JTree(top);
		scrollPane.setViewportView(tree);

		MyAbstractTreeTableModel treeTableModel = new MyDataModel(createDataStructure());

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 131, 398, 308);
		contentPane.add(scrollPane_1);
		MyTreeTable treetab = new MyTreeTable(treeTableModel);
		treetab.setBounds(10, 131, 398, 241);
		scrollPane_1.setViewportView(treetab);
		dao = new MySqlAccess();

	}

	private static MyDataNode createDataStructure() {
		List<MyDataNode> children1 = new ArrayList<MyDataNode>();
		children1.add(new MyDataNode("N12", "C12", new Date(), Integer.valueOf(50), null));
		children1.add(new MyDataNode("N12", "C12", new Date(), Integer.valueOf(50), null));
		children1.add(new MyDataNode("N12", "C12", new Date(), Integer.valueOf(50), null));
		children1.add(new MyDataNode("N13", "C13", new Date(), Integer.valueOf(60), null));
		children1.add(new MyDataNode("N14", "C14", new Date(), Integer.valueOf(70), null));
		children1.add(new MyDataNode("N15", "C15", new Date(), Integer.valueOf(80), null));

		List<MyDataNode> children2 = new ArrayList<MyDataNode>();
		children2.add(new MyDataNode("N12", "C12", new Date(), Integer.valueOf(10), null));
		children2.add(new MyDataNode("N13", "C13", new Date(), Integer.valueOf(20), children1));
		children2.add(new MyDataNode("N14", "C14", new Date(), Integer.valueOf(30), null));
		children2.add(new MyDataNode("N15", "C15", new Date(), Integer.valueOf(40), null));

		List<MyDataNode> rootNodes = new ArrayList<MyDataNode>();
		rootNodes.add(new MyDataNode("N1", "C1", new Date(), Integer.valueOf(10), children2));
		rootNodes.add(new MyDataNode("N2", "C2", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N3", "C3", new Date(), Integer.valueOf(10), children2));
		rootNodes.add(new MyDataNode("N4", "C4", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("Codice", "Desc", new Date(), Integer.valueOf(10), null));		
		rootNodes.add(new MyDataNode("N6", "C6", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N7", "C7", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N8", "C8", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N9", "C9", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N10", "C10", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N11", "C11", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N12", "C7", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N13", "C8", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N14", "C9", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N15", "C10", new Date(), Integer.valueOf(10), children1));
		rootNodes.add(new MyDataNode("N16", "C11", new Date(), Integer.valueOf(10), children1));
		MyDataNode root = new MyDataNode("R1", "R1", new Date(), Integer.valueOf(10), rootNodes);

		return root;
	}

	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode category = null;
		DefaultMutableTreeNode book = null;
		DefaultMutableTreeNode desc = null;
		category = new DefaultMutableTreeNode("Books for Java Programmers");
		top.add(category);

		// original Tutorial
		book = new DefaultMutableTreeNode("The Java Tutorial: A Short Course on the Basics");
		desc = new DefaultMutableTreeNode("desc");
		book.add(desc);
		category.add(book);

		// Tutorial Continued
		book = new DefaultMutableTreeNode("tutorialcont.html");
		category.add(book);

		// Swing Tutorial
		book = new DefaultMutableTreeNode("The Swing Tutorial: A Guide to Constructing GUIs");
		category.add(book);

		// ...add more books for programmers...

		category = new DefaultMutableTreeNode("Books for Java Implementers");
		top.add(category);

		// VM
		book = new DefaultMutableTreeNode("vm.html");
		category.add(book);

		// Language Spec
		book = new DefaultMutableTreeNode("jls.html");
		category.add(book);
	}
}
