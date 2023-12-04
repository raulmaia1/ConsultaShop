package br.com.consultashop.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.kamranzafar.jtar.TarEntry;
import org.kamranzafar.jtar.TarOutputStream;

public class Teste {

	public static void main(String[] args) {

		File pastaOrigem = new File("C:\\tmp\\");

		try {

			FileOutputStream destino = new FileOutputStream("C:\\Backup\\S9_Real.tar.gz");
			TarOutputStream out = new TarOutputStream(new BufferedOutputStream(destino));

			for (File f : pastaOrigem.listFiles()) {

				out.putNextEntry(new TarEntry(f, f.getName()));
				BufferedInputStream origin = new BufferedInputStream(new FileInputStream(f));

				int count;
				byte data[] = new byte[2048];
				while ((count = origin.read(data)) != -1) {
					out.write(data, 0, count);
				}

				out.flush();
				origin.close();
			}

			out.close();
			
//			// FTP

//			

//
//				FTPClient ftpClient = new FTPClient();
//
//				ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
//
//				ftpClient.connect("192.168.194.62", 21);
//				ftpClient.login("raul", "123");
//				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//
//				InputStream inputStream = new FileInputStream(new File(destino));
//				ftpClient.storeFile("/centercar/RAFAEL-24.11.2023.tar.gz",inputStream);
//				
//				ftpClient.completePendingCommand();
//				ftpClient.sendNoOp();
//				
//		
//				ftpClient.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
