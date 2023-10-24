package ChanningBabb_SharedLogger;

public class Main {

    private static final Logger LOG = Logger.getInstance();

    public static void main(String[] args) {
        LOG.log("Doing something...",3);
        LOG.log("Doing something that causes a warning...",2);
        LOG.log("Doing something that causes an error...",1);
    }
}
