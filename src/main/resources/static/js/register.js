function validatePasswords() {
    const pass = document.getElementById("password").value;
    const confirm = document.getElementById("confirmPassword").value;
    const error = document.getElementById("error");

    if (pass !== confirm) {
        error.style.display = "block";
        return false;
    } else {
        error.style.display = "none";
        return true;
    }
}
