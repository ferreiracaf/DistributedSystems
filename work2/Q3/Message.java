public class Message{
    int portTo;
    int portFrom;
    String strMsg;

    public Message(int _portTo, String _message, int _portFrom){
        try {
            this.portTo = _portTo;
            this.strMsg = _message;
            this.portFrom = _portFrom;
        } catch (Exception e) {
            System.out.println("Connection:"+e.getMessage());
        }
    }

    /**
     * @return the portTo
     */
    public int getPortTo() {
        return portTo;
    }

    /**
     * @param portTo the portTo to set
     */
    public void setPortTo(int portTo) {
        this.portTo = portTo;
    }

    /**
     * @return the portFrom
     */
    public int getPortFrom() {
        return portFrom;
    }

    /**
     * @param portFrom the portFrom to set
     */
    public void setPortFrom(int portFrom) {
        this.portFrom = portFrom;
    }

    /**
     * @return the strMsg
     */
    public String getStrMsg() {
        return strMsg;
    }

    /**
     * @param strMsg the strMsg to set
     */
    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }

   

}