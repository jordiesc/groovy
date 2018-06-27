import java.text.*
 class Executor {

    public static void main(def args) {
        println("Printing arguments");
        for(String arguments : args) {
            println (arguments);
        }
	tratar(args)
	
    }

    static def tratar(args) {
        def cli = new CliBuilder(usage: 'Executor.groovy -[h] [crear] [borrar] ')
        // Create the list of options.
        cli.with {
            h longOpt: 'help', 'Show usage information'

        }
        
        def options = cli.parse(args)
        if (!options) {
            return
        }
        // Show usage text when -h or --help option is used.
        if (options.h) {
            cli.usage()
            // Will output:
            // usage: showdate.groovy -[chflms] [date] [prefix]
            //  -h,--help                     Show usage information  
    
            return
        }
        
        def extraArguments = options.arguments()
        if (extraArguments) {
        print extraArguments
        }
        

    }

} 