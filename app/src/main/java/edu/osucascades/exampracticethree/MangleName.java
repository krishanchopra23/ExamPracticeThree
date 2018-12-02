package edu.osucascades.exampracticethree;

public class MangleName {

    private String mFirstName;
    private String mLastName;

    public MangleName(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
    }

    public String getMangledName() {
        return mFirstName + " " + mLastName;
    }
}
