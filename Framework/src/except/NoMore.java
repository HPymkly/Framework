package except;
public class NoMore extends No {

    public String genereMessage(String pathern, String cls) {
        return String.format(pathern, cls);
    }

    public NoMore(String cls) {
        super("");
        String pathern = "The class \"%s\" should have more than one field";
        this.setMessage(this.genereMessage(pathern, cls));
    }

}
