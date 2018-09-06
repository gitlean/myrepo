package com.isoft.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import com.isoft.vo.SSocks;

public class WriteFile {
	public static void write(List<SSocks> list) {

		File file = new File("E:/Shadowsocks/gui-config.json");
		if (file.exists()) {
			file.delete();
			System.out.println("删除文件" + "E:/Shadowsocks/gui-config.json");
		}

		File suffix = new File("E:/Shadowsocks/suffix.txt");
		BufferedReader reader = null;
		String line = null;

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			writer.append("{" + "\n");
			writer.append("  \"configs\":" + "[\n");

			for (int i = 0; i < list.size(); i++) {
				SSocks ss = list.get(i);
				writer.append("  {" + "\n");
				writer.append("    \"server\":" + "\"" + ss.getIp() + "\"" + ",\r\n");
				writer.append("    \"server_port\":" + "\"" + ss.getPort() + "\"" + ",\r\n");
				writer.append("    \"password\":" + "\"" + ss.getPwd() + "\"" + ",\r\n");
				writer.append("    \"method\":" + "\"" + ss.getCodeType() + "\"" + ",\r\n");
				if (i != list.size() - 1) {
					writer.append("    \"remarks\":" + "\"" + ss.getNation() + "\"" + "},\r\n");

				} else {
					writer.append("    \"remarks\":" + "\"" + ss.getNation() + "\"" + "}\r\n");
				}

			}

			writer.append("],\n");

			// ��׺
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(suffix)));
			while (null != (line = (reader.readLine()))) {
				writer.append(line + "\n");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
