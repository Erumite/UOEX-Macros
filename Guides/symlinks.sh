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
