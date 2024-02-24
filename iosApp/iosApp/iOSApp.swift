import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
//			ContentView()
			UserList(viewmodel: UserList.ViewModel())
		}
	}
}
