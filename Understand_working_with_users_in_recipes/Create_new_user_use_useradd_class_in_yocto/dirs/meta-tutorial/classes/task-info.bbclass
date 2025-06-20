# task-info.bbclass - This class provides a way to gather and display task information upon the completion of a task during the build process.

do_fetch_info() {
    # This function is called to gather task information.
    # It can be overridden in recipes to provide custom task information.
    bbplain "********************************************************"
    bbplain "Fetching task for ${PN} version ${PV}..."
    bbplain "**************************"
} 

addtask do_fetch_info before do_fetch

do_unpack_info() {
    bbplain "********************************************************"
    bbplain "Unpacking task for ${PN} version ${PV}..."
    bbplain "*********************************************************"
}

addtask do_unpack_info before do_unpack after do_fetch 

do_patch_info() {
    bbplain "********************************************************"
    bbplain "Patching task for ${PN} version ${PV}..."
    bbplain "*********************************************************"
}

addtask do_patch_info before do_patch after do_unpack

do_configure_info() {
   bbplain "********************************************************"
    bbplain "Configuring task for ${PN} version ${PV}..."
    bbplain "*********************************************************"
}

addtask do_configure_info before do_configure after do_patch

do_compile_info() {
    bbplain "********************************************************"
    bbplain "Compiling task for ${PN} version ${PV}..."
    bbplain "*********************************************************"
}


addtask do_compile_info before do_compile after do_configure

do_install_info() {
    bbplain "********************************************************"
    bbplain "Installing task for ${PN} version ${PV}..."
    bbplain "*********************************************************"
}

addtask do_install_info before do_install after do_compile