# Objective
Demonstrate the workflow to create, deploy to target, load and test a kernel module using devtool in Yocto Project.
Use the github repository "https://github.com/tianyuanhao/kernel-syslog" to get source code from.

Absolutely! Let's dive into the `insmod` and `lsmod` commands — essential tools for working with Linux **kernel modules**.

---

## 🧩 What Are Kernel Modules?

Kernel modules are **pieces of code that can be loaded and unloaded into the kernel** at runtime, extending its functionality without needing a reboot.

Examples:

* Device drivers (e.g., for USB, Wi-Fi, sound)
* File systems
* Network protocols

---

## 🔧 `insmod` – *Insert Module*

### ✅ Purpose:

Loads a kernel module into the running kernel.

### 📌 Syntax:

```bash
sudo insmod <module_name>.ko
```

### 💡 `.ko` stands for "kernel object".

### ⚠️ Notes:

* You must **provide the full path** if the module isn’t in the current directory.
* You **must be root** (use `sudo`).
* It doesn't resolve **dependencies** — it just loads the given module.

### 🧪 Example:

```bash
sudo insmod hello.ko
```

### 📥 Where to find `.ko` files?

They are usually built from source using a Makefile. Example output:

```
hello.ko
```

---

## 🔍 `lsmod` – *List Modules*

### ✅ Purpose:

Displays a list of all currently loaded kernel modules.

### 📌 Syntax:

```bash
lsmod
```

### 🧾 Output Columns:

| Column  | Description                                            |
| ------- | ------------------------------------------------------ |
| Module  | Name of the module                                     |
| Size    | Size in bytes                                          |
| Used by | Number of times it’s being used + which modules use it |

### 🧪 Example Output:

```text
Module         Size     Used by
hello          16384    0
usbcore        249856   6 xhci_hcd,ehci_hcd
```

---

## 🛠️ Typical Workflow

### 1. **Compile your module**:

```bash
make
```

### 2. **Insert it**:

```bash
sudo insmod hello.ko
```

### 3. **Check it's loaded**:

```bash
lsmod | grep hello
```

### 4. **View detailed info** (optional):

```bash
modinfo hello.ko
```

### 5. **Remove it** (complementary tool):

```bash
sudo rmmod hello
```

---

## 🔄 Difference: `insmod` vs. `modprobe`

| Command    | Resolves Dependencies? | Description                         |
| ---------- | ---------------------- | ----------------------------------- |
| `insmod`   | ❌ No                   | Loads only the specified `.ko` file |
| `modprobe` | ✅ Yes                  | Loads module and its dependencies   |

So:

```bash
sudo insmod my_driver.ko  # Use only if you're sure about dependencies  
sudo modprobe my_driver   # Safer and preferred in most cases
```

---

## 🧠 Summary

| Command    | Function                               |
| ---------- | -------------------------------------- |
| `insmod`   | Insert a module into the kernel        |
| `lsmod`    | List all currently loaded modules      |
| `rmmod`    | Remove a loaded module from the kernel |
| `modprobe` | Load/unload modules with dependencies  |

---

Great question! `dmesg` is a **powerful diagnostic command** used in Linux to inspect **kernel messages**—especially useful for **debugging hardware, drivers, and boot issues**.

---

## 🧠 What is `dmesg`?

`dmesg` stands for **"display message"**.
It prints messages from the **kernel ring buffer**, which logs events like:

* Boot process logs
* Device driver operations
* Hardware initialization
* Kernel warnings/errors
* Module insertions/removals

---

## 🧰 Basic Usage

```bash
dmesg
```

This shows a chronological list of kernel messages since boot.

---

## 🧪 Sample Output

```text
[    0.000000] Linux version 5.15.0 ...
[    1.234567] usb 1-1: new high-speed USB device number 2 using xhci_hcd
[    2.345678] eth0: link up
[   10.123456] hello: Hello, kernel module!
```

---

## 🔎 Why Use `dmesg`?

| Use Case                     | Example |                 |
| ---------------------------- | ------- | --------------- |
| See boot messages            | \`dmesg | less\`          |
| Debug USB devices            | \`dmesg | grep usb\`      |
| Check network drivers        | \`dmesg | grep eth\`      |
| Investigate crashes or bugs  | \`dmesg | grep -i error\` |
| Track kernel module activity | \`dmesg | grep hello\`    |

---

## 📂 Where Do These Messages Come From?

* The **kernel** logs events to a memory buffer called the **ring buffer**.
* `dmesg` reads from `/dev/kmsg` (or `/proc/kmsg` in older systems).

---

## 📌 Timestamps

* Default `dmesg` shows timestamps (seconds since boot).
* Use `-T` to convert them to human-readable format:

```bash
dmesg -T
```

Example:

```text
[Wed Jun 12 12:15:23 2025] usb 1-1: new device found
```

---

## 🔧 Common Options

| Option           | Description                                     |
| ---------------- | ----------------------------------------------- |
| `-T`             | Convert timestamps to readable format           |
| `-H`             | Human-readable pager interface (like `less`)    |
| `-k`             | Only show kernel messages (excluding userspace) |
| `--color=always` | Colorize output (if supported)                  |

---

## 🛑 Permissions

By default, non-root users may see **limited** output for security.
To see **all** logs:

```bash
sudo dmesg
```

---

## 🗑️ Clear the Buffer (Advanced)

```bash
sudo dmesg -C
```

> ⚠️ **Use carefully!** This wipes the current kernel message log.

---

## 🔄 Real-Time Monitoring (Alternative Tools)

If you want live kernel messages:

```bash
sudo journalctl -kf
```

This is part of `systemd` and shows real-time logs from the kernel, similar to `dmesg`.

---

## 📚 Summary

| Feature          | `dmesg` Helps You...                      |
| ---------------- | ----------------------------------------- |
| Hardware Issues  | Detect device errors or driver issues     |
| Boot Analysis    | Understand boot process and performance   |
| Module Debugging | Trace kernel module load/unload messages  |
| System Errors    | Catch kernel warnings, panics, or crashes |
| Timestamping     | Know exactly when events occurred         |

---

Let me know if you'd like to test it on your system or want examples of parsing specific device or driver logs!


