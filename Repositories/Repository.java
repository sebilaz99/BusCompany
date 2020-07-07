package Repositories;

import Classes.Route;

import java.util.ArrayList;

public class Repository
{
    private ArrayList<Route> routes;

    public Repository(){
        routes=new ArrayList<>();
    }

    public int find(int id)
    {
        for (int i=0; i<this.routes.size(); i++)
        {
            if (this.routes.get(i).getId()==id)
                return i;
        }
        return -1;
    }

    public boolean add(Route route)
    {
        this.routes.add(route);
        return true;
    }

    public boolean remove(int id)
    {
        int index = find(id);
        if(index!=-1)
        {
            this.routes.remove(index);
            return true;
        }
        return false;
    }

    public ArrayList<Route> getRoutes() {
        return this.routes;
    }

    public ArrayList<Route> get_list_by_source(String sourceCity){
        ArrayList<Route> aux=new ArrayList<>();
        for(Route r:this.routes){
            if(r.getSourceCity().equals(sourceCity))
                aux.add(r);
        }
        return aux;
    }

    public ArrayList<Route> get_routes_by_source_destination(String sourceCity,String destinationCity){
        ArrayList<Route> aux=new ArrayList<>();
        for(Route r:this.routes){
            if(r.getSourceCity().equals(sourceCity) && r.getDestCity().equals(destinationCity))
                aux.add(r);
        }
        return aux;
    }
}
