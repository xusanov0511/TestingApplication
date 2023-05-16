package com.company.testingsystem.client.ui;

import com.company.testingsystem.client.util.ScannerUtil;
import com.company.testingsystem.server.dto.Result;
import com.company.testingsystem.server.dto.UserDTO;
import com.company.testingsystem.server.model.User;
import com.company.testingsystem.server.service.AuthService;

public class AuthUI {

    AuthService authService = new AuthService();

    public void signUp() {
        System.out.print("Enter name: ");
        String name = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter username: ");
        String username = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter password: ");
        String password = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter confirm password: ");
        String confirmPassword = ScannerUtil.SCANNER_STR.nextLine();

        UserDTO userDTO = new UserDTO(name, username, password, confirmPassword);
        Result result = authService.signUp(userDTO);
        System.out.println(result);
    }


    public void login() {
        System.out.print("Enter username: ");
        String username = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter password: ");
        String password = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter confirm password: ");
        String confirmPassword = ScannerUtil.SCANNER_STR.nextLine();

        UserDTO userDTO = new UserDTO("", username, password, confirmPassword);
        Result result = authService.login(userDTO);
        System.out.println(result);
        if(result.success()){
            User sessionUser = authService.checkUsername(userDTO.username());
            UserUI userUI = new UserUI();
            userUI.cabinet(sessionUser);
        }
    }

    public void changePassword(User user) {
        AuthService authService = new AuthService();
        System.out.print("Enter current password: ");
        String currentPassword = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter new password: ");
        String password = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter confirm new password: ");
        String confirmPassword = ScannerUtil.SCANNER_STR.nextLine();

        Result result = authService.changePassword(user.getId(), currentPassword, password, confirmPassword);
        System.out.println(result);
    }
}
