package tool.component.api;

public class OS {

    public static final OSNode UBUNTU =
            new OSNode(
                    "ubuntu"
                    ,"/usr/bin"
                    ,"cd <|FILE_DIR|>;touch <|FILE_COMPILE|>;touch <|FILE_RUN|>");
    private OS(){}
}

class OSNode{

    private String osName;
    private String installation_dir;
    private String createcommand;

    OSNode(String osName,String installation_dir,String createCommands){
        this.osName = osName;
        this.installation_dir = installation_dir;
        this.createcommand = createCommands;
    }

    String getOsName() {
        return osName;
    }

    String getInstallation_dir() {
        return installation_dir;
    }

    String getCreatecommand(){
        return createcommand;
    }
}
