//
//  NavigationView.swift
//  iosApp
//
//  Created by hridoy das on 2024/02/11.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import UIKit
import Shared


struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct CustomNavigationView: View {
    var body: some View {
        NavigationView {
            VStack {
                ComposeView()
                    .ignoresSafeArea(.keyboard) // Compose has its own keyboard handler
                
                NavigationLink(destination: UserListView()) {
                    Text("Go to User List")
                        .padding()
                        .background(Color.blue)
                        .foregroundColor(Color.white)
                        .cornerRadius(10)
                }
            }
            .padding()

        }
    }
}

struct UserListView: View {
    var body: some View {
        UserList(viewmodel: UserList.ViewModel())
            .navigationBarTitle("Users")
    }
}


//#Preview {
//    NavigationView()
//}
