package frontend;

import frontend.demographic_details.SignUpOwner;
import frontend.demographic_details.SignUpUser;

import javax.swing.*;

public class Routing {


    private JFrame parentFrame;

    public Routing(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }


    public void navigateToUserSignUp() {
        parentFrame.setContentPane(new SignUpUser());
        parentFrame.revalidate();
        parentFrame.repaint();
    }

    public void navigateToOwnerSignUp() {
        parentFrame.setContentPane(new SignUpOwner());
        parentFrame.revalidate();
        parentFrame.repaint();
    }
}


