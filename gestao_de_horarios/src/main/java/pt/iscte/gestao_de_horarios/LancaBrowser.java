package pt.iscte.gestao_de_horarios;

import java.awt.Desktop;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LancaBrowser { 

	public static void main(String[] args) throws IOException {
		String urlStr = "https://github.com/vbasto-iscte/dataset-horarios/raw/main/SalasDeAulaPorTiposDeSala.html";
		final String file = "SalasDeAulaPorTiposDeSala.html";
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(System.getProperty("user.dir") + File.separator + file);
		byte[] buffer = new byte[1024];
		int count=0;
		while((count = bis.read(buffer,0,1024)) != -1)
		{
			fis.write(buffer, 0, count);
		}
		fis.close();
		bis.close();
		System.out.println("URL para o ficheiro html remoto a ser descarregado para o sistema de ficheiros local = " + urlStr);
		System.out.println("Caminho par o ficheiro html local = " + System.getProperty("user.dir"));
		System.out.println("Nome do ficheiro html local = " + file);

		JFrame frame = new JFrame("A Minha Aplicação");  
		JButton button = new JButton("Mostrar Salas no Browser Web");  
		button.setBounds(20,20,250,50);     
		button.addActionListener(new ActionListener(){  	
			public void actionPerformed(ActionEvent e){  
				File file = new File("C:\\Users\\tiago\\eclipse-workspace\\gestao_de_horarios\\src\\site\\index.html");
				//String filePath = "";
		        
		        // Codificar o caminho do arquivo
		        // String encodedFilePath = URLEncoder.encode(filePath, StandardCharsets.UTF_8);
		        
				Desktop desk = Desktop.getDesktop(); 
				try {
					 
					//desk.browse(new java.net.URI("file://C:\\Users\\tiago\\eclipse-workspace\\gestao_de_horarios\\SalasDeAulaPorTiposDeSala.html"));
					desk.browse(file.toURI());
				} catch (IOException e1) {e1.printStackTrace();} 
			}  
		});	    
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);  
		frame.setLayout(null);  
		frame.setVisible(true);   
	}  
}
