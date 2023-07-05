package Client;

public class ClientSocketApp {
	private static ClientOp cliente;
	private static final int PUERTO_SERVER = 8182;
	private static final String HOST_SERVER = "localhost";

    public static void main(String[] args) {
       cliente = new ClientOp(PUERTO_SERVER,HOST_SERVER);
	}

}
