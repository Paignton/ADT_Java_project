package utilities;

public class XMLTag {
	//Attributes
		private String tagName;
		private int line;
		private boolean closeTag;
		
		//constructor
		
		public XMLTag(String tagName, boolean closeTag)
		{
			// TODO Auto-generated method stub
			this.tagName = tagName;
			this.closeTag = closeTag;
		}
		
		public XMLTag(String tagName, int line, boolean closeTag)
		{
			// TODO Auto-generated method stub
			this.tagName = tagName;
			this.line = line;
			this.closeTag = closeTag;
		}
		
		public String getTagName() {
			// TODO Auto-generated method stub
			return this.tagName;
		}

		public void setTagName(String tagName) {
			// TODO Auto-generated method stub
			this.tagName = tagName;
		}

		public int getLine() {
			// TODO Auto-generated method stub
			return line;
		}

		public void setLine(int line) {
			// TODO Auto-generated method stub
			this.line = line;
		}

		public boolean isCloseTag() {
			// TODO Auto-generated method stub]
			return this.closeTag;
			
		}

		public void setCloseTag(boolean closeTag) {
			// TODO Auto-generated method stub
			this.closeTag = closeTag;
		}

		@Override
		public String toString() {
			return "XMLTag [tagName=" + tagName + ", line=" + line + ", closeTag=" + closeTag + "]";
		}
		

}
