package service;

import java.io.*;

public class FileServiceImpl implements FileService {

        @Override
        public void fileRead(File fileName) throws IOException {
             FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String st;
                while ((st = bufferedReader.readLine())!= null){
                    System.out.println(st);
                }
                bufferedReader.close();
        }

        @Override
        public void fileWrite(File fileName, String textNeedsToWrite) throws IOException {

            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n"+textNeedsToWrite);
            bufferedWriter.close();

            fileRead(fileName);



        }
}

