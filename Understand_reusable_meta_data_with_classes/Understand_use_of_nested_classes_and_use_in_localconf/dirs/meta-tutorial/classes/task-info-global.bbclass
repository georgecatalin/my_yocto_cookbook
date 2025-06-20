# task-info-global.bbclass - This class inherits another class to demonstrate the concept of nested classes in Yocto project

inherit task-info

do_special_task() {
    bbplain "********************************************************"
    bbplain "Executing special task for ${PN} version ${PV}..." between DO_UNPACK_INFO and DO_PATCH_INFO
    bbplain "*********************************************************"
}   

addtask do_special_task before do_patch_info after do_unpack_info