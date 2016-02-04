
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author lars
 */
public class FileCopy {
    
    /**
     * 
     * @param sourceFile
     * @param destinationFile
     * @throws IOException 
     */
    public void copyFile(File sourceFile, File destinationFile) throws IOException {
        
        if (!destinationFile.exists()) {
            destinationFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;
        
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destinationFile).getChannel();

            long count = 0;
            long size = source.size();
            while ((count += destination.transferFrom(source, count, size - count)) < size);
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
     }
        
}
