package ui;

public class UI {
    public static class Banner {

        // used in LMS-Admin
        public static final String authenticate = """
                                               █████╗ ██╗   ██╗████████╗██╗  ██╗███████╗███╗   ██╗████████╗██╗ ██████╗ █████╗ ████████╗███████╗
                                              ██╔══██╗██║   ██║╚══██╔══╝██║  ██║██╔════╝████╗  ██║╚══██╔══╝██║██╔════╝██╔══██╗╚══██╔══╝██╔════╝
                                              ███████║██║   ██║   ██║   ███████║█████╗  ██╔██╗ ██║   ██║   ██║██║     ███████║   ██║   █████╗  
                                              ██╔══██║██║   ██║   ██║   ██╔══██║██╔══╝  ██║╚██╗██║   ██║   ██║██║     ██╔══██║   ██║   ██╔══╝  
                                              ██║  ██║╚██████╔╝   ██║   ██║  ██║███████╗██║ ╚████║   ██║   ██║╚██████╗██║  ██║   ██║   ███████╗
                                              ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚═╝ ╚═════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝
                """;


        public static final String cadtLMS = """
                                                                           ██████╗ █████╗ ██████╗ ████████╗                                                                                               
                                                                           ██╔════╝██╔══██╗██╔══██╗╚══██╔══╝                                                                                               
                                                                           ██║     ███████║██║  ██║   ██║                                                                                                  
                                                                           ██║     ██╔══██║██║  ██║   ██║                                                                                                  
                                                                           ╚██████╗██║  ██║██████╔╝   ██║                                                                                                  
                                                                            ╚═════╝╚═╝  ╚═╝╚═════╝    ╚═╝                                                                                                  
                
                            ██╗     ███████╗ █████╗ ██████╗ ███╗   ██╗██╗███╗   ██╗ ██████╗     ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗███╗   ███╗███████╗███╗   ██╗████████╗    
                            ██║     ██╔════╝██╔══██╗██╔══██╗████╗  ██║██║████╗  ██║██╔════╝     ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝████╗ ████║██╔════╝████╗  ██║╚══██╔══╝    
                            ██║     █████╗  ███████║██████╔╝██╔██╗ ██║██║██╔██╗ ██║██║  ███╗    ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██╔████╔██║█████╗  ██╔██╗ ██║   ██║       
                            ██║     ██╔══╝  ██╔══██║██╔══██╗██║╚██╗██║██║██║╚██╗██║██║   ██║    ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║   ██║       
                            ███████╗███████╗██║  ██║██║  ██║██║ ╚████║██║██║ ╚████║╚██████╔╝    ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║ ╚═╝ ██║███████╗██║ ╚████║   ██║       
                            ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝╚═╝  ╚═══╝ ╚═════╝     ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝       
                
                                                                ███████╗██╗   ██╗███████╗████████╗███████╗███╗   ███╗                                                                                   
                                                                ██╔════╝╚██╗ ██╔╝██╔════╝╚══██╔══╝██╔════╝████╗ ████║                                                                                   
                                                                ███████╗ ╚████╔╝ ███████╗   ██║   █████╗  ██╔████╔██║                                                                                   
                                                                ╚════██║  ╚██╔╝  ╚════██║   ██║   ██╔══╝  ██║╚██╔╝██║                                                                                   
                                                                ███████║   ██║   ███████║   ██║   ███████╗██║ ╚═╝ ██║                                                                                   
                                                                ╚══════╝   ╚═╝   ╚══════╝   ╚═╝   ╚══════╝╚═╝     ╚═╝                                                                                   
                """;
        public static final String cadtLms_Admin = """
                                                                             ██████╗ █████╗ ██████╗ ████████╗                            
                                                                            ██╔════╝██╔══██╗██╔══██╗╚══██╔══╝                            
                                                                            ██║     ███████║██║  ██║   ██║                               
                                                                            ██║     ██╔══██║██║  ██║   ██║                               
                                                                            ╚██████╗██║  ██║██████╔╝   ██║                               
                                                                             ╚═════╝╚═╝  ╚═╝╚═════╝    ╚═╝                               
                
                                                        ██╗     ███╗   ███╗███████╗               █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗
                                                        ██║     ████╗ ████║██╔════╝              ██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║
                                                        ██║     ██╔████╔██║███████╗    █████╗    ███████║██║  ██║██╔████╔██║██║██╔██╗ ██║
                                                        ██║     ██║╚██╔╝██║╚════██║    ╚════╝    ██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║
                                                        ███████╗██║ ╚═╝ ██║███████║              ██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║
                                                        ╚══════╝╚═╝     ╚═╝╚══════╝              ╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝
                """;
        public static final String mainMenu = """
                                                                                   ╔╦╗╔═╗╦╔╗╔  ╔╦╗╔═╗╔╗╔╦ ╦
                                                                                   ║║║╠═╣║║║║  ║║║║╣ ║║║║ ║
                                                                                   ╩ ╩╩ ╩╩╝╚╝  ╩ ╩╚═╝╝╚╝╚═╝
                """;
        public static final String manageUser = """
                                                                                ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╦ ╦╔═╗╔═╗╦═╗╔═╗
                                                                                ║║║╠═╣║║║╠═╣║ ╦║╣   ║ ║╚═╗║╣ ╠╦╝╚═╗
                                                                                ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝  ╚═╝╚═╝╚═╝╩╚═╚═╝
                """;

        public static final String manageUniversity = """
                                                                           ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╦ ╦╔╗╔╦╦  ╦╔═╗╦═╗╔═╗╦╔╦╗╦ ╦
                                                                           ║║║╠═╣║║║╠═╣║ ╦║╣   ║ ║║║║║╚╗╔╝║╣ ╠╦╝╚═╗║ ║ ╚╦╝
                                                                           ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝  ╚═╝╝╚╝╩ ╚╝ ╚═╝╩╚═╚═╝╩ ╩  ╩  
                """;
        public static final String manageAdmin = """
                                                                                ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╔═╗╔╦╗╔╦╗╦╔╗╔╔═╗
                                                                                ║║║╠═╣║║║╠═╣║ ╦║╣   ╠═╣ ║║║║║║║║║╚═╗
                                                                                ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝  ╩ ╩═╩╝╩ ╩╩╝╚╝╚═╝
                """;
        public static final String manageStudent = """
                                                                            ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╔═╗╔╦╗╦ ╦╔╦╗╔═╗╔╗╔╔╦╗
                                                                            ║║║╠═╣║║║╠═╣║ ╦║╣   ╚═╗ ║ ║ ║ ║║║╣ ║║║ ║ 
                                                                            ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝  ╚═╝ ╩ ╚═╝═╩╝╚═╝╝╚╝ ╩  
                """;
        public static final String manageTeacher = """
                                                                             ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╔╦╗╔═╗╔═╗╔═╗╦ ╦╔═╗╦═╗
                                                                             ║║║╠═╣║║║╠═╣║ ╦║╣    ║ ║╣ ╠═╣║  ╠═╣║╣ ╠╦╝
                                                                             ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝   ╩ ╚═╝╩ ╩╚═╝╩ ╩╚═╝╩╚═
                """;
        public static final String manageGeneration = """
                                                                          ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╔═╗╔═╗╔╗╔╔═╗╦═╗╔═╗╔╦╗╦╔═╗╔╗╔
                                                                          ║║║╠═╣║║║╠═╣║ ╦║╣   ║ ╦║╣ ║║║║╣ ╠╦╝╠═╣ ║ ║║ ║║║║
                                                                          ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝  ╚═╝╚═╝╝╚╝╚═╝╩╚═╩ ╩ ╩ ╩╚═╝╝╚╝
                """;
        public static final String manageDepartment = """
                                                                        ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╔╦╗╔═╗╔═╗╔═╗╦═╗╔╦╗╔╦╗╔═╗╔╗╔╔╦╗
                                                                        ║║║╠═╣║║║╠═╣║ ╦║╣    ║║║╣ ╠═╝╠═╣╠╦╝ ║ ║║║║╣ ║║║ ║ 
                                                                        ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝  ═╩╝╚═╝╩  ╩ ╩╩╚═ ╩ ╩ ╩╚═╝╝╚╝ ╩  
                """;
        public static final String manageSpecialization = """
                                                                       ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╔═╗╔═╗╔═╗╔═╗╦╔═╗╦  ╦╔═╗╔═╗╔╦╗╦╔═╗╔╗╔
                                                                       ║║║╠═╣║║║╠═╣║ ╦║╣   ╚═╗╠═╝║╣ ║  ║╠═╣║  ║╔═╝╠═╣ ║ ║║ ║║║║
                                                                       ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝  ╚═╝╩  ╚═╝╚═╝╩╩ ╩╩═╝╩╚═╝╩ ╩ ╩ ╩╚═╝╝╚╝
                """;
        public static final String manageGroup = """
                                                                                ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╔═╗╦═╗╔═╗╦ ╦╔═╗
                                                                                ║║║╠═╣║║║╠═╣║ ╦║╣   ║ ╦╠╦╝║ ║║ ║╠═╝
                                                                                ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝  ╚═╝╩╚═╚═╝╚═╝╩ 
                """;
        public static final String manageClassroom = """
                                                                         ╔╦╗╔═╗╔╗╔╔═╗╔═╗╔═╗  ╔═╗╦  ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗╔╦╗
                                                                         ║║║╠═╣║║║╠═╣║ ╦║╣   ║  ║  ╠═╣╚═╗╚═╗╠╦╝║ ║║ ║║║║
                                                                         ╩ ╩╩ ╩╝╚╝╩ ╩╚═╝╚═╝  ╚═╝╩═╝╩ ╩╚═╝╚═╝╩╚═╚═╝╚═╝╩ ╩
                """;
        public static final String add = """
                                                                                             ╔═╗╔╦╗╔╦╗
                                                                                             ╠═╣ ║║ ║║
                                                                                             ╩ ╩═╩╝═╩╝
                """;
        public static final String edit = """
                                                                                             ╔═╗╔╦╗╦╔╦╗
                                                                                             ║╣  ║║║ ║ 
                                                                                             ╚═╝═╩╝╩ ╩ 
                """;
        public static final String delete = """
                                                                                        ╔╦╗╔═╗╦  ╔═╗╔╦╗╔═╗
                                                                                         ║║║╣ ║  ║╣  ║ ║╣ 
                                                                                        ═╩╝╚═╝╩═╝╚═╝ ╩ ╚═╝
                """;
        public static final String view = """
                                                                                            ╦  ╦╦╔═╗╦ ╦
                                                                                            ╚╗╔╝║║╣ ║║║
                                                                                             ╚╝ ╩╚═╝╚╩╝
                """;
        public static final String addStudentToGroup = """
                                                                        ╔═╗╔╦╗╔╦╗  ╔═╗╔╦╗╦ ╦╔╦╗╔═╗╔╗╔╔╦╗  ╔╦╗╔═╗  ╔═╗╦═╗╔═╗╦ ╦╔═╗
                                                                        ╠═╣ ║║ ║║  ╚═╗ ║ ║ ║ ║║║╣ ║║║ ║    ║ ║ ║  ║ ╦╠╦╝║ ║║ ║╠═╝
                                                                        ╩ ╩═╩╝═╩╝  ╚═╝ ╩ ╚═╝═╩╝╚═╝╝╚╝ ╩    ╩ ╚═╝  ╚═╝╩╚═╚═╝╚═╝╩
                """;


        public static final String assignTeacherToClassroom = """
                                                           ╔═╗╔═╗╔═╗╦╔═╗╔╗╔  ╔╦╗╔═╗╔═╗╔═╗╦ ╦╔═╗╦═╗  ╔╦╗╔═╗  ╔═╗╦  ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗╔╦╗
                                                           ╠═╣╚═╗╚═╗║║ ╦║║║   ║ ║╣ ╠═╣║  ╠═╣║╣ ╠╦╝   ║ ║ ║  ║  ║  ╠═╣╚═╗╚═╗╠╦╝║ ║║ ║║║║
                                                           ╩ ╩╚═╝╚═╝╩╚═╝╝╚╝   ╩ ╚═╝╩ ╩╚═╝╩ ╩╚═╝╩╚═   ╩ ╚═╝  ╚═╝╩═╝╩ ╩╚═╝╚═╝╩╚═╚═╝╚═╝╩ ╩
                """;

        public static final String assignCourseToClassroom = """
                                                            ╔═╗╔═╗╔═╗╦╔═╗╔╗╔  ╔═╗╔═╗╦ ╦╦═╗╔═╗╔═╗  ╔╦╗╔═╗  ╔═╗╦  ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗╔╦╗
                                                            ╠═╣╚═╗╚═╗║║ ╦║║║  ║  ║ ║║ ║╠╦╝╚═╗║╣    ║ ║ ║  ║  ║  ╠═╣╚═╗╚═╗╠╦╝║ ║║ ║║║║
                                                            ╩ ╩╚═╝╚═╝╩╚═╝╝╚╝  ╚═╝╚═╝╚═╝╩╚═╚═╝╚═╝   ╩ ╚═╝  ╚═╝╩═╝╩ ╩╚═╝╚═╝╩╚═╚═╝╚═╝╩ ╩        
                """;


        public static final String editName = """
                                                                                    ╔═╗╔╦╗╦╔╦╗  ╔╗╔╔═╗╔╦╗╔═╗
                                                                                    ║╣  ║║║ ║   ║║║╠═╣║║║║╣ 
                                                                                    ╚═╝═╩╝╩ ╩   ╝╚╝╩ ╩╩ ╩╚═╝
                """;
        public static final String editPhone = """                          
                                                                           ╔═╗╔╦╗╦╔╦╗  ╔═╗╦ ╦╔═╗╔╗╔╔═╗  ╔╗╔╦ ╦╔╦╗╔╗ ╔═╗╦═╗
                                                                           ║╣  ║║║ ║   ╠═╝╠═╣║ ║║║║║╣   ║║║║ ║║║║╠╩╗║╣ ╠╦╝
                                                                           ╚═╝═╩╝╩ ╩   ╩  ╩ ╩╚═╝╝╚╝╚═╝  ╝╚╝╚═╝╩ ╩╚═╝╚═╝╩╚═
                """;
        public static final String editEmail = """                          
                                                                                    ╔═╗╔╦╗╦╔╦╗  ╔═╗╔╦╗╔═╗╦╦  
                                                                                    ║╣  ║║║ ║   ║╣ ║║║╠═╣║║  
                                                                                    ╚═╝═╩╝╩ ╩   ╚═╝╩ ╩╩ ╩╩╩═╝
                """;
        public static final String editPassword = """                           
                                                                              ╔═╗╔╦╗╦╔╦╗  ╔═╗╔═╗╔═╗╔═╗╦ ╦╔═╗╦═╗╔╦╗
                                                                              ║╣  ║║║ ║   ╠═╝╠═╣╚═╗╚═╗║║║║ ║╠╦╝ ║║
                                                                              ╚═╝═╩╝╩ ╩   ╩  ╩ ╩╚═╝╚═╝╚╩╝╚═╝╩╚══╩╝
                """;

        public static final String editId = """
                                                                                        ╔═╗╔╦╗╦╔╦╗  ╦╔╦╗
                                                                                        ║╣  ║║║ ║   ║ ║║
                                                                                        ╚═╝═╩╝╩ ╩   ╩═╩╝
                """;


        public static final String success = """
                                                                               __  _  _  ___ ______  __   __  
                                                                             /' _/| || |/ _// _/ __/' _//' _/ 
                                                                             `._`.| \\/ | \\_| \\_| _|`._`.`._`. 
                                                                             |___/ \\__/ \\__/\\__/___|___/|___/  
                """;

        // LMS APP BANNERS

    }

    public static class TextColor {
        // Reset
        public static final String RESET = "\u001B[0m";

        // Regular Colors
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";

        // Bold Colors
        public static final String BLACK_BOLD = "\u001B[1;30m";
        public static final String RED_BOLD = "\u001B[1;31m";
        public static final String GREEN_BOLD = "\u001B[1;32m";
        public static final String YELLOW_BOLD = "\u001B[1;33m";
        public static final String BLUE_BOLD = "\u001B[1;34m";
        public static final String PURPLE_BOLD = "\u001B[1;35m";
        public static final String CYAN_BOLD = "\u001B[1;36m";
        public static final String WHITE_BOLD = "\u001B[1;37m";

        // Background Colors
        public static final String BLACK_BACKGROUND = "\u001B[40m";
        public static final String RED_BACKGROUND = "\u001B[41m";
        public static final String GREEN_BACKGROUND = "\u001B[42m";
        public static final String YELLOW_BACKGROUND = "\u001B[43m";
        public static final String BLUE_BACKGROUND = "\u001B[44m";
        public static final String PURPLE_BACKGROUND = "\u001B[45m";
        public static final String CYAN_BACKGROUND = "\u001B[46m";
        public static final String WHITE_BACKGROUND = "\u001B[47m";

        // Bright Colors
        public static final String BLACK_BRIGHT = "\u001B[90m";
        public static final String RED_BRIGHT = "\u001B[91m";
        public static final String GREEN_BRIGHT = "\u001B[92m";
        public static final String YELLOW_BRIGHT = "\u001B[93m";
        public static final String BLUE_BRIGHT = "\u001B[94m";
        public static final String PURPLE_BRIGHT = "\u001B[95m";
        public static final String CYAN_BRIGHT = "\u001B[96m";
        public static final String WHITE_BRIGHT = "\u001B[97m";

        // Bright Background Colors
        public static final String BLACK_BACKGROUND_BRIGHT = "\u001B[100m";
        public static final String RED_BACKGROUND_BRIGHT = "\u001B[101m";
        public static final String GREEN_BACKGROUND_BRIGHT = "\u001B[102m";
        public static final String YELLOW_BACKGROUND_BRIGHT = "\u001B[103m";
        public static final String BLUE_BACKGROUND_BRIGHT = "\u001B[104m";
        public static final String PURPLE_BACKGROUND_BRIGHT = "\u001B[105m";
        public static final String CYAN_BACKGROUND_BRIGHT = "\u001B[106m";
        public static final String WHITE_BACKGROUND_BRIGHT = "\u001B[107m";

        public static String addColor(String text, String color) {
            return color + text + RESET;
        }
    }

    public static void showLoadingBar(int totalTicks) {
        // For simplicity, we'll simulate a loading bar with ticks
        int width = 50;  // The width of the loading bar
        StringBuilder bar = new StringBuilder();

        // Print loading bar in the same line
        for (int i = 0; i <= totalTicks; i++) {
            // Clear the current line
            System.out.print("\r");

            // Add completed part
            int progress = (i * width) / totalTicks;
            bar.setLength(0); // Reset the bar for each iteration
            String temp = "#";
            temp = UI.TextColor.addColor(temp, UI.TextColor.GREEN);
            for (int j = 0; j < progress; j++) {
                bar.append(temp);
            }

            // Add the remaining part
            for (int j = progress; j < width; j++) {
                bar.append("-");
            }

            // Display the progress on the same line
            System.out.print("[" + bar.toString() + "] " + (i * 100) / totalTicks + "%");

            // Simulate a task being done
            try {
                Thread.sleep(100);  // Adjust the speed of the progress bar (in milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Clear the loading bar after completion
        System.out.print("\r" + " ".repeat(width + 10) + "\r");  // This clears the line
    }
}
