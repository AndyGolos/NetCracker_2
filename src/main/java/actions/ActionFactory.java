package actions;

import controllers.Controller;

import javax.servlet.http.HttpServletRequest;

public abstract class ActionFactory {

    public static Action getAction(HttpServletRequest request) {
        String path = request.getServletPath();
        int slashIndex = path.lastIndexOf('/');
        int period = path.lastIndexOf('.');
        return Controller.classMapping.get(request.getMethod() + "/" + path.substring(slashIndex + 1, period));
    }
}
