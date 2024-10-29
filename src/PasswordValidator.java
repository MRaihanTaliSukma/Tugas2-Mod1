import java.util.regex.Pattern;
// Custom Exceptionclass InvalidPasswordException extends Exception {
public InvalidPasswordException(String message) {        super(message);
}}
public class PasswordValidator {
    // Fungsi utama untuk memvalidasi password
    public static void validatePassword(String password) throws InvalidPasswordException {        // Memeriksa panjang password
        if (password.length() < 8) {            throw new InvalidPasswordException("Password harus memiliki panjang minimal 8 karakter.");
        }
        // Memeriksa keberadaan huruf besar        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
        throw new InvalidPasswordException("Password harus mengandung setidaknya satu huruf besar (A-Z).");        }
    // Memeriksa keberadaan huruf kecil
        if (!Pattern.compile("[a-z]").matcher(password).find()) {            throw new InvalidPasswordException("Password harus mengandung setidaknya satu huruf kecil (a-z).");
    }
    // Memeriksa keberadaan angka        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu angka (0-9).");        }
// Memeriksa keberadaan karakter khusus
        if (!Pattern.compile("[!@#$%^&*]").matcher(password).find()) {            throw new InvalidPasswordException("Password harus mengandung setidaknya satu karakter khusus ('!', '@', '#', '$', '%', '^', '&', '*').");
        }    }
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Masukkan password: ");        String password = scanner.nextLine();
    try {
        // Memvalidasi password            validatePassword(password);
        System.out.println("Password valid.");        } catch (InvalidPasswordException e) {
        // Menangkap dan menampilkan pesan kesalahan dari custom exception            System.out.println("Password tidak valid: " + e.getMessage());
    }
    scanner.close();    }
}
