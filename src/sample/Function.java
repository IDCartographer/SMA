package sample;
import java.io.*;
import java.util.ArrayList;

public  class Function
{

    public static void Reader (String fileWay, int ValueSMA)
    {
        try
        {
            FileInputStream fin=new FileInputStream(fileWay);
            ArrayList<Double> rawData=new ArrayList<Double>();
            ArrayList<Double> finalData=new ArrayList<Double>();
            FileReader fr = new FileReader(fileWay);
            FileWriter  nFile=new FileWriter ("C:\\Users\\Aleks\\IdeaProjects\\FX-SMA-Project\\RawData.txt");
            FileWriter  fFile=new FileWriter ("C:\\Users\\Aleks\\IdeaProjects\\FX-SMA-Project\\SMAData.txt");

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            nFile.write(line);
            nFile.write("\n");
            rawData.add(new Double(Double.parseDouble(line)));
            while (!(line.equals(null)))
            {
                //System.out.println(line);
                line = reader.readLine();
                if(line.equals("")){break;}
                double i=Double.valueOf(line);
                rawData.add((i));
                nFile.write(line);
                nFile.write("\n");
                nFile.flush();

            }

            for (int i = 0; i < rawData.size(); i++) {
                double value = 0;
                if (i + ValueSMA <= rawData.size()) {
                    for (int j = 0; j < ValueSMA; j++) {
                        int count = i + j;
                        value += rawData.get(count);
                    }
                    fFile.write(String.valueOf(value/ValueSMA));
                    fFile.write("\n");
                    fFile.flush();
                    finalData.add(value / ValueSMA);
                }
            }
            fin.close();
            fr.close();
            nFile.close();
            fFile.close();
            reader.close();




        }
        catch (FileNotFoundException e)
        {
            System.out.println("Отсутствует файл");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }




    }

}

