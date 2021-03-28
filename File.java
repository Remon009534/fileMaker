package com.company;
import java.time.LocalDateTime;
public class File {
    private String FileId;
    private String FileName;
    private String FileType;
    private LocalDateTime FileCreated;
    private static int FileCount;

    public File(String FileName, String FileType)
    {
        this.FileId = IdCreator(FileType);
        this.FileName = FileName;
        this.FileType = FileType;
        this.FileCreated = LocalDateTime.now();
    }

    private String IdCreator(String FileType)
    {
        return FileType + "_" + ++FileCount;
    }

    public String getFileName()
    {
        return FileName;
    }
    public void setFileName(String FileName)
    {
        this.FileName = FileName;
    }
    public String getFileType()
    {
        return FileType;
    }
    public void setFileType(String FileType)
    {
        this.FileType = FileType;
    }

    public boolean FileTypeChecker(String FileType)
    {
        try
        {
            if(FileType == "txt" || FileType == "doc" || FileType == "py")
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
