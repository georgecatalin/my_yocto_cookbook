# Objective
Demonstrate the contents of conf/local.conf and the workflow to create an image that adds a password to the root user in Yocto.

Great! Let’s break down the command step-by-step **in a way that makes it easy to remember and understand**:

---

## 🔢 Full command:

```bash
printf "%q" $(openssl passwd thispass)
```

---

## 🎯 What does it do?

It **hashes a password** using `openssl`, then **prints the hashed password in a safe format** for use in a shell script (with all special characters escaped).

---

## 🧠 Breakdown and memory trick:

### 🔹 `openssl passwd thispass`

* Think: 🔐 “**Generate password hash**”
* `openssl` = a toolbox for encryption
* `passwd` = the subcommand to hash passwords
* `thispass` = the plaintext password
* 🔄 This gives you something like: `$1$zFkQYpQo$8PUFjHoKxhPxbdZT2w1Ex0`

✅ You now have a hashed password.

---

### 🔹 `$(...)` – Command substitution

* Think: 💬 “**Run this first and use the result here**”
* So the result of `openssl passwd thispass` becomes the input for `printf`.

---

### 🔹 `printf "%q"` – Quote/escape special shell characters

* Think: 🛡️ “**Make this string safe for shell usage**”
* `%q` = tells `printf` to **escape any characters** that might cause issues (like `$`, `!`, `\`, etc.)
* Result is a **shell-quoted safe string**.

For example:

```bash
printf "%q" '$1$Z3m3...weird!chars'
```

➡️ Output:

```bash
\$1\$Z3m3...weird\!chars
```

---

## 📝 Mnemonic to remember:

> **"OpenSSL makes the hash, `printf %q` escapes the bash."**

---

## 🔚 In short:

* `openssl passwd thispass` → hash password
* `$(...)` → run first, pass output
* `printf "%q"` → escape it for safe script use

Let me know if you'd like a version that stores the result in a variable or appends it to a file!


Great question, George! The short answer is:

> ❌ **No**, you cannot change a user's password directly using `usermod`.

Instead, you should use the **`passwd` command** for that purpose.

---

## ✅ Correct Way: Use `passwd` to Change Password

### 🔧 For your own password:

```bash
passwd
```

### 🔧 To change another user’s password (as root):

```bash
sudo passwd username
```

🧪 Example:

```bash
sudo passwd george
```

You’ll be prompted to enter the new password twice.

---

## ❓Why Not `usermod`?

* `usermod` modifies **account metadata** (like shell, groups, home dir).
* **Password hashes** are stored in `/etc/shadow`, and `passwd` is the safe tool to update them.
* There’s a `-p` option in `usermod`, but it expects an **already encrypted (hashed)** password — so it’s not practical or secure for normal use.

---

## ⚠️ Don't Do This:

```bash
sudo usermod -p mypassword george  # 🚫 WRONG — this sets the raw string as a hash!
```

This creates a **non-functional or insecure login**.

---

## ✅ Summary

| Task                | Use `usermod`? | Use `passwd`? |
| ------------------- | -------------- | ------------- |
| Change shell        | ✅ Yes          | ❌ No          |
| Add to group        | ✅ Yes          | ❌ No          |
| Change password     | ❌ No           | ✅ Yes         |
| Lock/unlock account | ✅ Yes (`-L`)   | ❌ No          |

---

Would you like a script that resets passwords for a list of users securely?
