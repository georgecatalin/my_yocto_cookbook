# Objective
Demonstrate the worflow to build a Linux Kernel module out of the tree and test it on the target machine with modprobe or insmod, rmmod , lsmod.

## Notes
### modprobe: FATAL: Module hello.ko not found in directory /lib/modules/5.15.150-yocto-standard


means that `modprobe` is looking for the **kernel module by name**, not by filename, and it's not properly **installed in the expected directory structure**.

Let me explain what's happening and how to fix it ✅

---

## 🧠 What’s Going On?

* `modprobe hello.ko` is **incorrect syntax** — `modprobe` expects a **module name**, not a filename.
* It looks for a file like:

  ```
  /lib/modules/$(uname -r)/hello.ko
  ```

  or more typically:

  ```
  /lib/modules/$(uname -r)/extra/hello.ko
  ```

---

## ✅ Correct Usage

If you compiled `hello.ko` manually or via a Yocto module recipe but didn't install it with `make modules_install` or similar:

### ✅ 1. Use `insmod` for raw `.ko` files

If you're in the same directory:

```bash
insmod hello.ko
```

✅ This loads the module directly — no need for it to be registered in `/lib/modules`.

### ✅ 2. Use `modprobe` only after installing properly

If you want to use `modprobe`, the module must be:

1. In a valid path under `/lib/modules/$(uname -r)/`
2. Indexed by `depmod`

---

## 🛠️ Fix for `modprobe` to Work

### Step 1: Copy the module to the kernel’s `extra` directory

```bash
cp hello.ko /lib/modules/$(uname -r)/extra/
```

Create the folder if missing:

```bash
mkdir -p /lib/modules/$(uname -r)/extra
```

### Step 2: Rebuild the module dependency list

```bash
depmod -a
```

### Step 3: Load using `modprobe` (now without `.ko` extension)

```bash
modprobe hello
```

> If it still fails, check `dmesg` for errors like "invalid module format".

---

## 🧪 Bonus: Check What Kernel You Built the Module Against

Run on target:

```bash
uname -r
```

Then compare to what your module was compiled against. They must match exactly.

If you built the module with Yocto:

* Make sure your recipe installed it to the correct location.
* Use `bitbake -c deploy kernel-module-hello` and verify `MODULES_INSTALL_DIR` was populated correctly.

---

## ✅ Summary

| Task                          | Solution                                      |
| ----------------------------- | --------------------------------------------- |
| Load temporary `.ko` module   | `insmod hello.ko`                             |
| Load installed module by name | `modprobe hello` (no `.ko`)                   |
| Prepare system for `modprobe` | Copy to `/lib/modules/...`, then run `depmod` |
| Fix missing `.ko` message     | Use correct module name and path              |

---

### 🧠 What is `uname`?

`uname` stands for **Unix Name**.
It reports information about the **system, kernel, and architecture**.

---

## ✅ Basic Usage

```bash
uname
```

Outputs just the **kernel name**, usually:

```
Linux
```

---

## 📦 Full Usage with Options

Use `-a` to get **all** available information:

```bash
uname -a
```

Sample output:

```
Linux beaglebone-yocto 5.15.150-yocto-standard #1 SMP PREEMPT Mon Jun 10 10:22:33 UTC 2025 armv7l GNU/Linux
```

---

## 🔍 Breakdown of `uname -a` Output

| Field                     | Meaning                 |
| ------------------------- | ----------------------- |
| `Linux`                   | Kernel name (`-s`)      |
| `beaglebone-yocto`        | Hostname (`-n`)         |
| `5.15.150-yocto-standard` | Kernel release (`-r`)   |
| `#1 SMP PREEMPT...`       | Kernel version (`-v`)   |
| `armv7l`                  | Machine hardware (`-m`) |
| `GNU/Linux`               | Operating system (`-o`) |

---

## 🧰 Common `uname` Options

| Option | Description                         | Example Output            |
| ------ | ----------------------------------- | ------------------------- |
| `-s`   | Kernel name                         | `Linux`                   |
| `-n`   | Node name (hostname)                | `beaglebone-yocto`        |
| `-r`   | Kernel release                      | `5.15.150-yocto-standard` |
| `-v`   | Kernel version                      | `#1 SMP PREEMPT ...`      |
| `-m`   | Machine hardware name (CPU type)    | `armv7l`, `x86_64`        |
| `-p`   | Processor type (often same as `-m`) | `unknown` or `x86_64`     |
| `-i`   | Hardware platform (arch-specific)   | `unknown`, `armv7l`       |
| `-o`   | Operating system                    | `GNU/Linux`               |
| `-a`   | All above combined                  | Everything above          |

---

## 🛠️ Useful Combos

### ✅ Just the architecture (cross-compiling?):

```bash
uname -m
```

### ✅ Only the kernel version:

```bash
uname -r
```

### ✅ Just the OS type:

```bash
uname -o
```

---

## 📚 Real-World Use Cases

| Use Case                           | Command    |
| ---------------------------------- | ---------- |
| Check if you're on ARM or x86      | `uname -m` |
| Get full kernel info for debugging | `uname -a` |
| Verify target platform in Yocto    | `uname -r` |
| Identify OS type in scripts        | `uname -o` |

---

## ✅ Bonus Tip: Use in Scripts

```bash
if [[ "$(uname -m)" == "x86_64" ]]; then
    echo "Running on 64-bit Intel/AMD"
fi
```

---

## 🧠 Summary

| What You Want    | Use        | Example Output            |
| ---------------- | ---------- | ------------------------- |
| Kernel name      | `uname -s` | `Linux`                   |
| Hostname         | `uname -n` | `beaglebone-yocto`        |
| Kernel release   | `uname -r` | `5.15.150-yocto-standard` |
| Kernel version   | `uname -v` | `#1 SMP PREEMPT ...`      |
| Machine/CPU type | `uname -m` | `armv7l`, `x86_64`        |
| Operating system | `uname -o` | `GNU/Linux`               |

---

Let me know if you want a quick script that logs `uname` info into a file for debugging embedded boards!
