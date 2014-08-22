/*
 * Kevin Borling
 * CSCD 316 | Practical Problem Solving
 * Problem 2.8.6 | Erdos Numbers
 * 05/04/2013
 */
   import java.util.*;
   import java.io.*;

   class Erdos
      {
      String lines[];
      String coauthors[][];
      String findNames[];
      String searchItem;
      boolean found=false;
      static InputStreamReader isr = new InputStreamReader(System.in);
      static final BufferedReader bin =new BufferedReader(isr);
      //static Scanner we = new Scanner(System.in);
      public static void main(String args[]) throws IOException
         {
         int scenarios, papers, authors;
         Erdos erdos=new Erdos();
      
      //First input number of scenarios
         try{
            while(bin.ready())
               {
               scenarios=Integer.parseInt(bin.readLine()); //read()
            
            //Now start a loop for reading total number of scenarios
               for(int scenario=1;scenario<=scenarios;scenario++)
                  {
               //Now read the line containing the number of papers and authors
                  StringTokenizer line = new StringTokenizer(bin.readLine()," ");//read()
                  papers=Integer.parseInt(line.nextToken());
                  authors=Integer.parseInt(line.nextToken());
               
               //Read a line containing author names along with book names
                  erdos.lines=new String[papers];
                  for(int i=0;i < papers;i++)
                     erdos.lines[i]=bin.readLine(); //read()
               
               //Read a line containing the names to be searched
                  erdos.findNames = new String[authors];
                  for(int i=0;i< authors;i++)
                     erdos.findNames[i]=bin.readLine(); //read()
               
               //Now generate the array
                  erdos.buildArray();
               //Now search
                  System.out.println("Scenario "+scenario);
                  for(int i=0;i < authors;i++)
                     {
                     erdos.searchItem = erdos.findNames[i];
                     if(erdos.searchItem.equals("Erdos, P."))
                        {
                        System.out.println("Erdos, P. 0");
                        continue;
                        }
                     erdos.depthSearch(erdos.findNames[i],1,new ArrayList());
                     if(erdos.found==false) System.out.println(erdos.searchItem+" infinity");
                     erdos.found=false;
                     }
                  }
               }
            }
            catch(Exception e)
               {
               System.out.println("Failed to parse");
               }
         
         }
   /*
      static String read() throws IOException
         {
         String line;
         while(true)
            {
            line=bin.readLine();
            if(line==null) 
               break; //eof
            else if(line.length()==0) 
               continue; //blank line
            else
               {
               line=line.trim().replaceAll("\\s+"," ");
               return line;
               }
            }
         return null;
         }
   */
      private void buildArray()
         {
         String str;
         coauthors = new String[lines.length][];
         for(int i=0;i<lines.length;i++)
            {
         
            str = lines[i];
            str = str.substring(0,str.indexOf(':'));
            str+=",";
            coauthors[i]=new String[(countCommas(str)+1)>>1];
            for(int j=0;j < coauthors[i].length;j++)
               {
               str = str.trim();
               coauthors[i][j]="";
               coauthors[i][j]+= str.substring(0,str.indexOf(','))+",";
               str = str.substring(str.indexOf(',')+1);
               coauthors[i][j]+= str.substring(0,str.indexOf(','));
               str = str.substring(str.indexOf(',')+1);
               }
            }
         }
   
      private int countCommas(String s)
         {
         int num=0;
         for(int i=0;i<s.length();i++)
            if(s.charAt(i)==',') num++;
         return num;
         }
   
      private void depthSearch(String searchElem,int ernosDepth,ArrayList searchedElem)
         {
         ArrayList searchSpace=new ArrayList();
         searchedElem.add(searchElem);
         for(int i=0;i < coauthors.length;i++)
         
            for(int j=0;j < coauthors[i].length;j++)
               {
               if(coauthors[i][j].equals(searchElem))    //Add all authors name in this group
                  {
                  for(int k=0;k < coauthors[i].length;k++)
                     {
                     if(coauthors[i][k].equals("Erdos, P.")) //Found
                        {
                        found=true;
                        System.out.println(searchItem+" "+ernosDepth);
                        return;
                        }
                     else if(searchedElem.contains(coauthors[i][k]) || searchSpace.contains(coauthors[i][k])) 
                        continue;
                     searchSpace.add(coauthors[i][k]);
                     }
                  break;
                  }
               }
         Iterator i=searchSpace.iterator();
         while(i.hasNext())
            {
            String cSearchElem=(String)i.next();
            depthSearch(cSearchElem,ernosDepth+1,searchedElem);
            }
         }
      }