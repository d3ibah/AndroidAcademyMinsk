package by.androidacademyminsk.les_03_RecyclerView;

import android.net.Uri;

class Actor {

    private String fullName;
    private Uri preview;
    private Uri fullImage;
    private String info;


    public Actor(String fullName, Uri preview, Uri fullImage, String info) {
        this.fullName = fullName;
        this.preview = preview;
        this.fullImage = fullImage;
        this.info = info;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Uri getPreview() {
        return preview;
    }

    public void setPreview(Uri preview) {
        this.preview = preview;
    }

    public Uri getFullImage() {
        return fullImage;
    }

    public void setFullImage(Uri fullImage) {
        this.fullImage = fullImage;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
