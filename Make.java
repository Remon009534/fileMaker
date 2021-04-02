package com.company;
import java.time.LocalDateTime;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Make {
    private String mId;
    private String mName;
    private String mContent;
    private LocalDateTime mCreated;
    private static int mCount;

    public Make(String mName, String mType, String mContent) {
        if (TypeChecker(mType)) {
            this.SetMId(IdCreator(mType));
            this.SetMName(mName, mType);
            this.setMContent(mContent);
            this.SetMCreated();
            this.MakeFile();
        } else {
            System.out.println("File type not supported.");
        }
    }

    public String GetMId() {
        return mId;
    }

    public void SetMId(String mId) {
        this.mId = mId;
    }

    public String GetMName() {
        return mName;
    }

    public void SetMName(String mName, String mType) {
        this.mName = mName + "." +mType;
    }
    public String getMContent()
    {
        return mContent;
    }
    public void setMContent(String mContent)
    {
        this.mContent = mContent;
    }
    public LocalDateTime GetMCreated() {
        return mCreated;
    }

    public void SetMCreated() {
        this.mCreated = LocalDateTime.now();
    }

    private static String IdCreator(String mType) {
        return (mType + ++mCount);
    }

    private boolean TypeChecker(String mType) {
        if (mType.equals("txt") || mType.equals("doc") || mType.equals("py")) {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void MakeFile() {
        try {
            File file = new File(this.GetMName());
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

        try
        {
           FileWriter myWriter = new FileWriter(this.GetMName());

           myWriter.write(this.getMContent());
           myWriter.close();
            System.out.println("File Write Successfully");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred");
        }
    }

    public void ShowInfo() {
        System.out.println("Filename: " + this.GetMName());
        System.out.println("File Created on: " + this.GetMCreated());
    }
}
