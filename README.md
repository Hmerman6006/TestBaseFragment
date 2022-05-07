# TestBaseFragment
Test Base Fragment repository test base fragments with different class initialiser arguments and viewmodel scopes  to lessen boilerplate.

1. BaseFragment
   - Fragment extends ViewBinding and takes fragment binding inflator as initialiser arguments.
2. BaseWithViewModelFragment
   - Fragment extends ViewBinding and ViewModel; and takes fragment binding inflator as  initialiser arguments.
   - For ViewModel the choice exist to scope by fragment versus activity.
