import java.io.Serializable;
import java.net.Socket;

public class Request implements Serializable {

    private Operation operacije;

    private Object data;

    public Request(Object data, Operation operacije) {
        this.operacije = operacije;
        this.data = data;
    }

    public Operation getOperacije() {
        return operacije;
    }

    public Object getData() {
        return data;
    }

    public void setOperacije(Operation operacije) {
        this.operacije = operacije;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
