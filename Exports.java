import edu.duke.*;
import org.apache.commons.csv.*;

public class Exports{
    public void listExporters(CSVParser parser, String exportsOfInterest)
    {
        int c=0;
        for(CSVRecord record : parser)
        {
            String export=record.get("Exports");
            if(export.contains(exportsOfInterest))
            {
                c++;
            System.out.println(record.get("Country"));
            }
        }
        System.out.println(c);
        
    }
    public void ExportsTwoItems(CSVParser parser, String exportItem1, String exportItem2)
    {
        for(CSVRecord record : parser)
        {
            String export=record.get("Exports");
            if(export.contains(exportItem1)&&export.contains(exportItem2))
            {
            System.out.println(record.get("Country"));
            }
        }
        
    }
    public void countryInfo(CSVParser parser , String country )
    {
        int flag=0;
       for(CSVRecord record : parser)
        {
            String countryName=record.get("Country");
            System.out.println(countryName);
            if(countryName.equals(country))
            {
                flag=1;
            System.out.println(record.get("Country")+" : "+record.get("Exports")+" : "+record.get("Value (dollars)"));
            }
        } 
        if(flag==0)
        System.out.println("NOT FOUND");
    }
    public void Economy(CSVParser parser, String amount)
    {
       int c=0;
        for(CSVRecord record : parser)
        {
            String export=record.get("Value (dollars)");
           // int length=export;
            //System.out.println(record.get("Country")+" "+export);
       if(export.length()>amount.length())
            {
                c++;
            System.out.println(record.get("Country"));
            }
        }
        System.out.println(c);
    }

    public void whoExports()
    {
    FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        //listExporters(parser,"cocoa");
        Economy(parser,"$999,999,999,999");
        //countryInfo(parser,"Germany");
        //ExportsTwoItems(parser,"cotton","flowers");
    }

}
