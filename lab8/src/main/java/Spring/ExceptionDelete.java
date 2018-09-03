package Spring;

public class ExceptionDelete extends Exception {

    private int kod;
    private String error;

    public ExceptionDelete(int kod, String error) {
        this.kod = kod;
        this.error = error;
    }
    public void exceptionMsg() {
        System.err.println( "ExceptionDelete[" + this.kod + "]:\t" + this.error + "!" );
    }
}

