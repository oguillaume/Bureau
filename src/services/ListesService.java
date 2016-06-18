/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bdd.Electeur;
import bdd.Personne;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adm
 */
public class ListesService {

        public final static char SEPARATOR = '\t';

    public static String getResourcePath(String fileName) {
        final File f = new File("");
        final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
        System.out.println("dossierPath="+dossierPath);
        return dossierPath;
    }

    public static File getResource(String fileName) {
        final String completeFileName = getResourcePath(fileName);
        System.out.println("fileName="+completeFileName);
        File file = new File(completeFileName);
        return file;
    }

    private List<String> chargerFichierElecteur(File file) throws FileNotFoundException {
        FileReader infile;
        List<String> result = new ArrayList<String>();
        try {
            infile = new FileReader(file);
            BufferedReader buff = new BufferedReader(infile);
            for (String line = buff.readLine(); line != null; line = buff.readLine()) {
                result.add(line);
            }
            buff.close();
            infile.close();
            return result;
        } catch (IOException ex) {
            Logger.getLogger(ListesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<String[]> chargementTables(File file) {
        List<String[]> data = null;
        List<String> lines;
        System.out.println("ole2");
        try {
            lines = chargerFichierElecteur(file);
            System.out.println("ole");
            data = new ArrayList<String[]>(lines.size());
            String sep =new Character(SEPARATOR).toString();
            for (String line : lines) {
                String[] oneData = line.split(sep);
                data.add(oneData);
            }
            return data;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
   

}
