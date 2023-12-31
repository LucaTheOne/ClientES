/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package emotionalsongs.clientES;

import java.rmi.*;

/**
 *
 * @author big
 */
public class ServicesProvider{
    
    public static final int EMOTIONS_DATA_HANDLER = 0;
    public static final int USERS_DATA_HANDLER = 1;
    public static final int SONGS_DATA_HANDLER = 2;
    public static final int PLAYLISTS_DATA_HANDLER = 3;
    
    public static final int EMOTIONS_DATA_VALIDATOR = 4;
    public static final int USERS_DATA_VALIDATOR = 5;
    public static final int PLAYLISTS_DATA_VALIDATOR = 6;
    
    protected static ServicesProvider singleton = null;
    private ServicesBox servicesBox;
    public static ServicesProvider getInstance(){
        if(singleton == null){
            System.out.println("Error, Service provider not initialized yet!");
        }
        return singleton;
    }
    
    /**
     * Metodo costruttore della classe.
     * Richiama il cotruttore di ServicesBox
     * @param serviceHost
     * @param servicePort 
     */
    protected ServicesProvider(String serviceHost,int servicePort) {
        servicesBox = new ServicesBox(serviceHost, servicePort);
    }
    
    /**
     * Metodo che richiede il riferimento remoto al ServicesBox
     * @param serviceId
     * @return restituisce il riferimento remoto al metodo richiesto
     */
    public Remote getService(int serviceId){
        return servicesBox.getService(serviceId);
    }
    
    /**
     * Crea un'istanza di ServicesBox chiamandone il costruttore
     * @param servicesHost
     * @param servicesPort 
     */
    protected void buildServicesBox(String servicesHost,int servicesPort){
        servicesBox = new ServicesBox(servicesHost, servicesPort);
    }
    
    /**
     * Sblocca tutti i thread in attesa
     */
    protected void unlock(){
        notifyAll();
    }
    /*    
    public static void main(String[] args) throws RemoteException {
        ServicesProvider sp = ServicesProvider.getInstance();
        SongsDataHandler sdh = (SongsDataHandler) sp.getService(ServicesProvider.SONGS_DATA_HANDLER);
        int res = sdh.getRepoSize();
        System.out.println(res);
    }
    */
}
