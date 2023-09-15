package com.project.event;

public class PublicEvent {

    //Khai báo đối tượng interface
    private static PublicEvent instance;
    private EventMain eventMain;
    private EventImageView eventImageView; //interface
    private EventChat eventChat;
    private EventLogin eventLogin;
    private EventMenuLeft eventMenuLeft;

    /**
     * hàm xử lý trả về đối tượng PublicEvent
     *
     * @return
     */
    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent(); // tạo đối tượng instance để dễ gọi xử lý event
        }
        return instance;
    }

    private PublicEvent() {

    }

    /*
       getter setter(add) Event Main
     */
    public void addEventMain(EventMain event) {
        this.eventMain = event;
    }

    public EventMain getEventMain() {
        return eventMain;
    }

    /*
       getter setter(add) Event Image View
     */
    public void addEventImageView(EventImageView event) {
        this.eventImageView = event;
    }

    public EventImageView getEventImageView() {
        return eventImageView;
    }

    /*
       getter setter(add) Event Chat
     */
    public void addEventChat(EventChat event) {
        this.eventChat = event;
    }

    public EventChat getEventChat() {
        return eventChat;
    }

    /*
       getter setter(add) Event Login
     */
    public void addEventLogin(EventLogin event) {
        this.eventLogin = event;
    }

    public EventLogin getEventLogin() {
        return eventLogin;
    }

    /*
       getter setter(add) Event Menu Left
     */
    public void addEventMenuLeft(EventMenuLeft event) {
        this.eventMenuLeft = event;
    }

    public EventMenuLeft getEventMenuLeft() {
        return eventMenuLeft;
    }
}
