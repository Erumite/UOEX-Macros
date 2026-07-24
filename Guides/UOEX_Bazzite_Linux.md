# UO Excelsior in a Bottle on Bazzite Linux

Things you'll need: 

|Software|Source|
|---|---|
|Bottles|Installed via Bazaar FlatPak|
|UO Excelsior files|Download from [uoex.net](https://uoex.net/startup)|
|Classic UO Launcher|[ClassicUO Website](https://www.classicuo.eu/)|
|Razor Enhanced Files|[Razor Enhanced Website](https://ultimatools.github.io/razorenhanced.github.io/)|
|Symlink Script|This repo (optional)|
|Flatseal|Via Bazaar if SymLinking (optional)|
|Patience|Inner Peace (required)|

## Setup Steps
**I cannot stress the importance of doing this in the correct order without variation.**  
I frequently had problems where the wrong order would break the bottle irrepairably.  
For example, if you run `ClassicUOLauncher.exe` before WebView2 is installed, the bottle is trash.

### Setup Bottles
1. Open Bottles and go to Preferences -- 3 Line menu in top-right, or `Ctrl+,`
2. Click the Runners tab at the top.
3. Expand the Proton GE section and install `ge-proton11-1`
    * As of date of writing, this is the latest version.
4. Once it has installed, go back to the main menu.


### Create the Bottle
1. Open Bottles and create a new bottle with the `+` in the top left. 
2. Name it `UOEX`  (Recommended)
3. Select "Gaming" type and set the Runner to `ge-proton11-1`
4. Leave Bottle Directory as `Default`
5. Click `[Create]` and let it spin.

![CreateBottle](https://files.catbox.moe/5uv7a0.png)

### Install WebView2
1. Select the bottle and scroll down to the Dependencies section.
2. Click into it and search for `webview2` - Install ONLY this.

![Install Webview](https://files.catbox.moe/g5o8i5.png)

### Copy Files Into Container
1. Back on the main page for the UOEX bottle, click `Browse` to open the container `C:\` Drive.
2. Copy `uoml_excelsior_expatch12.exe` directly into the C drive.
3. Create a folder at `C:\ClassicUO` and copy `ClassicUOLauncher.exe` into it from your zip.
4. Unzip RazorEnhanced-x.x.x.zip and remove the version from the folder.
5. Copy this to `C:\RazorEnhanced` 

### Install Client Files
1. Back on the main bottle view for `UOEX` bottle, click `Run Executable...`
2. In the weird file browser, open the `drive_c` folder
3. Select and open `uoml_excelsior_expatch12.exe`
4. In the window that pops up, hit `Extract` (directly into `C:\` is fine)

Note: You can delete `uoml_excelsior_expatch12.exe` at this point.  You might want to keep a version in your downloads in case things go sideways so you don't have to re-download it.

![Run Executable](https://files.catbox.moe/dxdssz.png)

### Install ClassicUO
1. Click `Run Executable...` again and select the `ClassicUOLauncher.exe` file.
2. It SHOULD open up and download the files needed.
3. Click Select Profile -> New Profile and fill in details. (below)
4. At the bottom, under Plugins, click Browse and point it to `RazorEnhanced.exe`
5. The first time you click `Play Desktop`, you will get an error - this is a Launcher Bug.
6. Either re-start the Launcher OR click `Change` again and click the `Play` button on the profile we just made.

**-- Profile Settings --**
* **Profile Name**: "UOExcelsior"  (whatever is fine)
* **Ultima Online Path** : `C:\Ultima Online - Excelsior Shard`
* **ClassicUO Path**: Leave empty
* **Client Version**: `5.0.9.1` (should auto-fill)
* **User/Pass** : Fill in if you want.
* **Server Address** : `shard.uoex.net`
* **Port**: `60`
* **Plugins** : Point to `C:\RazorEnhanced\RazorEnhanced.exe`

The other options are up to you.

If you get a white screen that just hangs forever when you open the launcher, bad luck.  Delete the bottle and start at the beginning and make sure that WebView2 is installed before you try opening it.

### You're in!  But there's more!
You should get logged into the game and Razor should be running!  Now close it.  No UO for you yet.

Under the Programs section of the main UOEX Bottle, click `+ Add Shortcuts...` and select `ClassicUO.exe` - not the launcher.  This should launch it directly using the profile that we just set up.

You can also click the 3-dot menu dropdown to create a Desktop Shortcut that you can launch from.

![Add Desktop Shortcut](https://files.catbox.moe/fjpbvt.png)

---

## Optional Setup and Migration Of Settings

### Notes on Migrating Your Scripts + Profiles
#### **WARNING**: Some settings may get broken while migrating if the paths changed or if they contain Hotkeys!

If you open up your scripts, agents, etc and all the settings are gone, it's likely one of two things: 

* The paths have changed: `D:\Old\Path` becomes `C:\New\Path`, etc.
    * You can do a search and replace of the settings files for anything containing your old path.
* Non-Zero Hotkey Values
    * It seems the key mappings (integers) for hotkeys differ between Windows and Linux.
    * Any files containing Hotkey assignments are likely to break and be emptied out.
    * Search for any files containing `"Hotkey":` in it and set them **ALL** to Zero.
        * If you have an editor that supports regex, try replacing `"Hotkey": \d+,` with `"Hotkey": 0,`
* Profile Name Change
    * Linux is case sensitive `Name` and `name` are two different folders whereas on Windows they're the same.
    * Actual changes like swapping from a named profile to `default` and vice versa. 
    * You can simply copy the files from one profile into the directory of another.

**ANOTHER WARNING** : Make sure UO is closed while copying and moving around files or it will probably freeze. 

A git repository in your data directory goes a long way to keeping track of what is getting changed.

### Symlink Your Scripts and Profiles

This is an optional step, but I'd prefer to have my scripts outside of the bottle and in a more accessible location.  Namely, `~/Documents/UOData/`

The script below assumes the bottle name is `UOEX`, but if you changed it, it will take the bottle name as the first argument.

It will move the Razor Scripts, Razor Profiles and CUO Profiles into `~/Documents/UOData` if the destination does not already exist.  If the directory already exists, the directories are removed in the bottle. 

Then, it creates a symlink from the bottle file system to the ones in Documents.

You can keep your config in this directory and not worry about losing it if the bottle is deleted, share it between bottles (not recommended to do at the same time), or track your profile/scripts with git. 

**YOU MUST GIVE BOTTLES ACCESS** to your Documents folder before you do this as it does not have this access normally.

1. Open `FlatSeal` and find `Bottles`
2. Scroll down to `Other files` and add `~/Documents/UOData`
3. Once this is done, you can run the script below or set up the symlinks yourself.

*NOTE: I have not tested this thoroughly yet - hopefully this is all the config needed to be portable.*

![Allow in FlatSeal](https://files.catbox.moe/gqnzqu.png)

```shell
#!/usr/bin/env bash

set -euo pipefail

BOTTLE_NAME="${1:-UOEX}"

BOTTLE_ROOT="${HOME}/.var/app/com.usebottles.bottles/data/bottles/bottles/${BOTTLE_NAME}"

declare -A LINKS=(
    ["${BOTTLE_ROOT}/drive_c/RazorEnhanced/Scripts"]="${HOME}/Documents/UOData/RazorEnhanced/Scripts"
    ["${BOTTLE_ROOT}/drive_c/RazorEnhanced/Profiles"]="${HOME}/Documents/UOData/RazorEnhanced/Profiles"
    ["${BOTTLE_ROOT}/drive_c/ClassicUO/ClassicUO/Data/Profiles"]="${HOME}/Documents/UOData/ClassicUO/Profiles"
)

echo "Configuring shared Ultima Online data for bottle '${BOTTLE_NAME}'..."
echo

for SRC in "${!LINKS[@]}"; do
    DST="${LINKS[$SRC]}"

    echo "==> ${SRC}"
    echo "    -> ${DST}"

    mkdir -p "${DST}"

    if [[ -L "${SRC}" ]]; then
        echo "    Existing symlink found; replacing."
        rm "${SRC}"

    elif [[ -d "${SRC}" ]]; then
        echo "    Migrating existing files..."

        # Copy everything that doesn't already exist.
        cp -an "${SRC}/." "${DST}/"

        rm -rf "${SRC}"

    elif [[ -e "${SRC}" ]]; then
        echo "ERROR: ${SRC} exists but is not a directory or symlink."
        exit 1
    fi

    ln -s "${DST}" "${SRC}"

    echo "    Done."
    echo
done

echo "Finished!"
echo
echo "Your shared data is now stored under:"
echo "  ${HOME}/Documents/UOData"
```

# You're in Gamer

If this got you in, you owe me a million gold.  Or a coffee.  Honor system.

[![Buy me a coffee](https://cdn.ko-fi.com/cdn/kofi3.png?v=1)](https://ko-fi.com/yourusername)

