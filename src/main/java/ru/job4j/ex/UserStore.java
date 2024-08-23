package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws ElementNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                user = users[i];
                break;
            }
        }
        if (user == null) {
            throw new ElementNotFoundException("This user not found.");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = false;
        if (user.isValid() && user.getUsername().length() >= 3) {
            result = true;
        } else {
            throw new UserInvalidException("This user not valid.");
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException es) {
            es.printStackTrace();
        }
    }
}

