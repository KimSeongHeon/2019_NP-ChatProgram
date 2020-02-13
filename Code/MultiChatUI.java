import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;
//201511182 소프트웨어 김성헌
public class MultiChatUI extends JFrame{

    // 로그인 패널
    private JPanel loginPanel;
    // 로그인 버튼
    protected JButton loginButton;

    // 대화명 라벨
    private JLabel inLabel;
    // 대화명 출력 라벨
    protected JLabel outLabel;
    // 대화명 입력 텍스트필드
    protected JTextField idInput;

    // 로그아웃 패널
    private JPanel logoutPanel;
    // 로그아웃 버튼
    protected JButton logoutButton;

    // 메시지 입력  패널 구성
    private JPanel msgPanel;
    // 메시지 입력 텍스트필드
    protected JTextField msgInput;
    // 종료 버튼
    protected JButton exitButton;

    // 채팅 내용 출력창
    protected JTextArea msgOut;

    // 화면 구성 전환을 위한 카드레이아웃
    protected Container tab;
    protected CardLayout cardLayout;

    // 로그인 아이디 저장 필드
    protected String id;

    // 생성자
    public MultiChatUI() {

        super("::멀티챗::");
        // 메인 프레임 구성
        getContentPane().setLayout(new BorderLayout());
        // 로그인 패널 화면 구성 (JPanel)
        loginPanel = new JPanel();
        // 로그인 패널 레이아웃 설정
        loginPanel.setLayout(new BorderLayout());
        // 로그인 입력필드/버튼 생성
        inLabel = new JLabel("대화명");
        idInput = new JTextField();
        loginButton = new JButton("로그인");
        // 로그인 패널에 위젯 구성 (add메소드이용하여 위에서 생성한 필드/버튼 등 패널에 추가)
        loginPanel.add(inLabel,BorderLayout.WEST);
        loginPanel.add(idInput,BorderLayout.CENTER);
        loginPanel.add(loginButton,BorderLayout.EAST);
        // 로그아웃 패널 구성 (JPanel)
        logoutPanel = new JPanel();
        // 로그아웃 패널 레이아웃 설정
        logoutPanel.setLayout(new BorderLayout());
        // 로그아웃 버튼 생성
        outLabel = new JLabel("대화명 :");
        logoutButton = new JButton("로그아웃");
        //로그아웃 패널에 위젯 구성
        logoutPanel.add(outLabel,BorderLayout.CENTER);
        logoutPanel.add(logoutButton,BorderLayout.EAST);
        // 메시지 입력 패널 구성 (JPanel)
        msgPanel = new JPanel();
        // 레이아웃 설정
        msgPanel.setLayout(new BorderLayout());
        //메세지 입력필드, 버튼 생성
        msgInput = new JTextField();
        exitButton = new JButton("종료");
        // 메시지 입력 패널에 위젯 구성
        msgPanel.add(msgInput,BorderLayout.CENTER);
        msgPanel.add(exitButton,BorderLayout.EAST);
        // 로그인/로그아웃 패널 선택을 위한 CardLayout 패널
        tab = new Container();
        cardLayout = new CardLayout();
        tab.setLayout(cardLayout);
        tab.add("login",loginPanel);
        tab.add("logout",logoutPanel);
        // 메시지 출력 영역 초기화
        msgInput.setText("");
        // JTextArea 의 내용을 수정하지 못하도록 함. 즉 출력전용으로 사용
        msgOut = new JTextArea();
        msgOut.setEditable(false);
        // 메시지 출력(msgOut) 영역 스크롤바 구성, 수직 스크롤바는 항상 나타내고 수평 스크롤바는 필요시 나타나도록 함. (JScrollPane)
        JScrollPane scrollPane = new JScrollPane(msgOut,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // 메인 프레임에 패널 배치 (tab, jsp, msgPanel)
        getContentPane().add(tab,BorderLayout.NORTH);
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        getContentPane().add(msgPanel,BorderLayout.SOUTH);
        // loginPanel 을 우선 보이도록 함.
        /****/
        // 프레임 크기 자동으로 설정
        setSize(400,400);
        // 프레임 크기 조정 불가 설정
        setResizable(false);
        // 프레임이 보여지도록 함
        setVisible(true);
    }

    /**
     * 이벤트 리스너 등록을 위한 메서드로 파라미터의 리스너 객체는 컨트롤러에서 구현한 객체가 됨.
     * 따라서 실제 이벤트 처리는 컨트롤러 클래스 코드를 따라감.
     * @param listener
     */
    public void addButtonActionListener(ActionListener listener) {
        // 이벤트 리스너 등록
        loginButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        logoutButton.addActionListener(listener);
        msgInput.addActionListener(listener);

    }
    
    
    ///* this main() method is here only for testing UI, and should be deleted or commented out later
    /*public static void main(String[] args) {
    	
    	//MultiChatUI v = new MultiChatUI();
    	//MultiChatData mcd = new MultiChatData();
    	//MultiChatController mc = new MultiChatController(mcd,v);
    	//mc.appMain();
    	v.addButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                // 종료버튼 처리
                if (obj == v.exitButton) {
                    System.exit(0);
                } else if (obj == v.loginButton) {
                    v.id = v.idInput.getText();
                    v.outLabel.setText(" 대화명 : " + v.id);
                    v.cardLayout.show(v.tab, "logout");
                } else if (obj == v.logoutButton) {
                    // 대화창 클리어
                    v.msgOut.setText("");
                    // 로그인 패널로 전환
                    v.cardLayout.show(v.tab, "login");
                } else if (obj == v.msgInput) {
                    // 입력창 클리어
                    v.msgInput.setText("");
                }
            }
        });*/
    //} //delete or comment out this method when working with MultiChatController*/
}
