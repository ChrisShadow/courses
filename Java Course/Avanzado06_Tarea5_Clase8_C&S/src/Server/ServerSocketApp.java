package Server;

public class ServerSocketApp {

	private static ServerOp serve;
	private static final int PUERTO_SERVER = 8182;

    public static void main(String[] args) {
    	serve = new ServerOp(PUERTO_SERVER);
	}

}
