package Repositories;

import Classes.Route;

import java.io.*;

public class TextRepository extends Repository
{
    private String filename;

    public TextRepository(String filename)
    {
        this.filename = filename;
        if(this.filename.contains("route")) createRoute();
    }

    public int find(int id)
    {
        int ok = find(id);
        return ok;
    }

    public boolean add(Route route)
    {
        boolean ok = super.add(route);
        if(ok)
            if(route instanceof Route) writeRoute();
        return ok;
    }

    void writeRoute()
    {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(this.filename));
            for (Route route : this.getRoutes())
            {
                if(route instanceof Route)
                    bw.write(((Route) route).getSourceCity());
                bw.write(" - ");
                bw.write(((Route) route).getDestCity());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally
        {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean remove (int id)
    {
        boolean ok = super.remove(id);
        return ok;
    }

    void createRoute()
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(this.filename));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                String[] elems = line.split("[|]");
                if (elems.length < 2)
                    continue;
                Route route = new Route((elems[0].strip()),elems[1].strip(),Integer.parseInt(elems[2].strip()),
                        Integer.parseInt(elems[3].strip()),Integer.parseInt(elems[4].strip()),Integer.parseInt(elems[5].strip()),Integer.parseInt(elems[6].strip()));
                this.add(route);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
                try {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error while closing the file " + e);
                }
        }
    }
}
