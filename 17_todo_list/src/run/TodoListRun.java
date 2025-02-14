package run;

import view.TodoListView;

public class TodoListRun {
	public static void main(String[] args) {
		
		// Run -> View <-> Service <-> DAO <-> File
		
		new TodoListView().startView();
	}
}
