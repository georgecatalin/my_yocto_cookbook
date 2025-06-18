# Objective
Demonstrate the workflow around saving the Linux Kernel configuration so that they remain persistent even after on does a 'do_cleansstate' command to remove all precompiled binaries

## Practical Steps involved
* Create a .bbappend file
* Modify the linux kernel using the 'menuconfig'
* Save the modification using 'savedefconfig'
* Copy the .defconfig file to the folder associated to the .bbappend file
* Build the image 

## Practical notes
### `KCONFIG`
In Yocto recipes, the `KCONFIG` variable is used to specify the kernel configuration method or target. It tells the kernel build system which configuration file or method to use when preparing the kernel build.

In your example:

```bitbake
KCONFIG = "allnoconfig"
```

- `allnoconfig` is a special target for the Linux kernel's `make` command. It creates a minimal kernel configuration with almost all options disabled.
- This is often used as a starting point for custom kernel configurations, where you want to enable only specific features.

**Summary:**  
`KCONFIG` sets the kernel configuration target (like `defconfig`, `allnoconfig`, etc.) that will be used during the kernel build process.

### Error resolutions
Thanks, George — this error is common when using `SRC_URI = "file://..."`, and it's a **typo or misconfiguration issue**.

---

## ❌ The Error:

```
Could not find a fetcher which supports the URL: 'files://defconfig'
```

The key problem is:

> `files://defconfig` is **invalid syntax** — `files://` is not a valid fetcher.

---

## ✅ Solution

### ✅ Use `file://`, not `files://`

Correct:

```bitbake
SRC_URI = "file://defconfig"
```

**Not**:

```bitbake
SRC_URI = "files://defconfig"  # ❌ wrong
```

---

## 🔁 Fix Checklist

1. Open your `.bb` recipe

2. Search for this line:

   ```bitbake
   SRC_URI = "files://defconfig"
   ```

3. Change it to:

   ```bitbake
   SRC_URI = "file://defconfig"
   ```

4. Make sure that the file actually exists at:

   ```
   meta-your-layer/recipes-*/<your-recipe>/files/defconfig
   ```
s
5. Then clean and rebuild:

```bash
bitbake -c cleanall <your-recipe>
bitbake <your-recipe>
```

---

## ✅ Summary

| Incorrect           | Correct            |
| ------------------- | ------------------ |
| `files://defconfig` | `file://defconfig` |

Let me know the name of the recipe and if you need help placing `defconfig` in the right folder!
