package until;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.util.ArrayList;
/**
 * ����Ϊ�ж�ͼƬ�Ƿ���������Ĺ���
 * @author YLove
 * @version V1.0
 */
public class isOK {
	/**
	 *  �÷���Ϊ�ж�����ͼƬ�Ƿ���������Ĺ���
	 * @param p  ��¼�ڶ���ѡ��ͼƬ��λ��
	 * @param GameSize ���ִ�С��������
	 * @param index ��¼��һ��ѡ��ͼƬ��label
	 * @param path_line  ��¼����·����ӦͼƬ����
	 * @param label_arr ��¼label���鹦��
	 * @param path ��¼����·��
	 * @return �����ͼƬ������������true�����򷵻�false
	 */
	public static boolean is_OK(Point p,int GameSize,int index,int[] path_line,ArrayList label_arr,ArrayList path) {
		
		int W = 50;
		int k = p.x/W+p.y/W*GameSize;
		
		if(index == k)
			return false;
		if(((JLabel)label_arr.get(index)).getIcon()!=((JLabel)label_arr.get(k)).getIcon())
			return false;
		
		//�����ж�
		int index_top=index, index_left=index, index_right=index, index_bottum=index;//��һ�������ĸ����������
		int k_top=k, k_left=k, k_right=k, k_bottum=k;//�ڶ��������ĸ����������
		
		for(int i=index-GameSize;i>0;i-=GameSize) {
			if(((JLabel)label_arr.get(i)).getIcon() != null) {
				index_top = i+GameSize;
				break;
			}
			if(i < GameSize)
				index_top = i;
		}
		for(int i=index-1;i>index/GameSize*GameSize-1;i--) {
			if(((JLabel)label_arr.get(i)).getIcon() != null) {
				index_left = i+1;
				break;
			}
			if(i == index/GameSize*GameSize)
				index_left = index/GameSize*GameSize;
		}
		for(int i=index+1;i<(index/GameSize+1)*GameSize;i++) {
			if(((JLabel)label_arr.get(i)).getIcon() != null) {
				index_right = i-1;
				break;
			}
			if(i == (index/GameSize+1)*GameSize-1)
				index_right = (index/GameSize+1)*GameSize-1;
		}
		for(int i=index+GameSize;i<GameSize*GameSize;i+=GameSize) {
			if(((JLabel)label_arr.get(i)).getIcon() != null) {
				index_bottum = i-GameSize;
				break;
			}
			if(i > GameSize*GameSize-1-GameSize)
				index_bottum = i;
		}
		for(int i=k-GameSize;i>0;i-=GameSize) {
			if(((JLabel)label_arr.get(i)).getIcon() != null) {
				k_top = i+GameSize;
				break;
			}
			if(i < GameSize)
				k_top = i;
		}
		for(int i=k-1;i>k/GameSize*GameSize-1;i--) {
			if(((JLabel)label_arr.get(i)).getIcon() != null) {
				k_left = i+1;
				break;
			}
			if(i == k/GameSize*GameSize)
				k_left = k/GameSize*GameSize;
			
		}
		for(int i=k+1;i<(k/GameSize+1)*GameSize;i++) {
			if(((JLabel)label_arr.get(i)).getIcon() != null) {
				k_right = i-1;
				break;
			}
			if(i == (k/GameSize+1)*GameSize-1)
				k_right = (k/GameSize+1)*GameSize-1;
		}
		for(int i=k+GameSize;i<GameSize*GameSize;i+=GameSize) {
			if(((JLabel)label_arr.get(i)).getIcon() != null) {
				k_bottum = i-GameSize;
				break;
			}
			if(i > GameSize*GameSize-1-GameSize)
				k_bottum = i;
		}
		
		//ˮƽ����
		if(index/GameSize > k/GameSize) {  //��һ���ڵڶ����·�
			int i=index, p1=index+1, f=0;
			while(true) {
				if(i<index_left && p1>index_right)
					break;
				ArrayList arr = new ArrayList();
				if(f == 0) {
					if(i>=index_left && i%GameSize>=k_left%GameSize && i%GameSize<=k_right%GameSize) {
						for(int t = i;t <= index;t++) {
							arr.add(t);
							path_line[t] = 0;
						}
						path_line[i] = 3;

						for(int j = i-GameSize;j>0;j-=GameSize) {
							System.out.println("aaal");
							arr.add(j);
							path_line[j] = 1;
							if(j/GameSize == k/GameSize) {
								for(int t = 0;t < arr.size();t++) {
									path.add(arr.get(t));
								}
								if(j<k) {
									for(int t = j+1;t <= k;t++) {
										path.add(t);
										path_line[t] = 0;
									}
									path_line[j] = 4;
								} else {
									for(int t = j-1;t >= k;t--) {
										path.add(t);
										path_line[t] = 0;
									}
									path_line[j] = 5;
								}
								return true;
							}
							if(((JLabel)label_arr.get(j)).getIcon() != null) {
								arr.clear();
								break;
							}
						}
					}
					i--;
					f = 1;
				} else {
					if(p1<=index_right && p1%GameSize>=k_left%GameSize && p1%GameSize<=k_right%GameSize) {
						for(int t = p1;t >= index;t--) {
							arr.add(t);
							path_line[t] = 0;
						}
						path_line[p1] = 2;		  
						for(int j = p1-GameSize;j>0;j-=GameSize) {
							System.out.println("aaar");
							arr.add(j);
							path_line[j] = 1;
							if(j/GameSize == k/GameSize) {
								for(int t = 0;t < arr.size();t++) {
									path.add(arr.get(t));
								}
								if(j<k) {
									for(int t = j+1;t <= k;t++) {
										path.add(t);
										path_line[t] = 0;
									}
									path_line[j] = 4;
								} else {
									for(int t = j-1;t >= k;t--) {
										path.add(t);
										path_line[t] = 0;
									}
									path_line[j] = 5;
								}
								return true;
							}
							if(((JLabel)label_arr.get(j)).getIcon() != null) {
								arr.clear();
								break;
							}
						}
					}
					p1++;
					f = 0;
				}
			}
		} else if(index/GameSize < k/GameSize) {	  //�ڶ����ڵ�һ���·�
			int i=index,p1=index+1,f=0;
			while(true) {
				if(i<index_left && p1>index_right)
					break;
				ArrayList arr = new ArrayList();
				if(f == 0) {
					if(i>=index_left && i%GameSize>=k_left%GameSize && i%GameSize<=k_right%GameSize) {
						for(int t = i;t <= index;t++) {
							arr.add(t);
							path_line[t] = 0;
						}
						path_line[i] = 4;
						for(int j = i+GameSize;j>0;j+=GameSize) {
							System.out.println("bbbl");
							arr.add(j);
							path_line[j] = 1;
							if(j/GameSize == k/GameSize) {
								for(int t = 0;t < arr.size();t++) {
									path.add(arr.get(t));
								}
								if(j<k) {
									for(int t = j+1;t <= k;t++) {
										path.add(t);
										path_line[t] = 0;
									}
									path_line[j] = 3;
								} else {
									for(int t = j-1;t >= k;t--) {
										path.add(t);
										path_line[t] = 0;
									}
									path_line[j] = 2;
								}
								return true;
							}
							if(((JLabel)label_arr.get(j)).getIcon() != null) {
								arr.clear();
								break;
							}
						}
					}
					i--;
					f = 1;
				} else {
					if(p1<=index_right && p1%GameSize>=k_left%GameSize && p1%GameSize<=k_right%GameSize) {
						for(int t = p1;t >= index;t--) {
							arr.add(t);
							path_line[t] = 0;
						}
						path_line[p1] = 5;
						for(int j = p1+GameSize;j>0;j+=GameSize) {
							System.out.println("bbbr");
							arr.add(j);
							path_line[j] = 1;
							if(j/GameSize == k/GameSize) {
								for(int t = 0;t < arr.size();t++) {
								path.add(arr.get(t));
								}
								if(j<k) {
									for(int t = j+1;t <= k;t++) {
										path.add(t);
										path_line[t] = 0;
									}
									path_line[j] = 3;
								} else {
									for(int t = j-1;t >= k;t--) {
										path.add(t);
										path_line[t] = 0;
									}
									path_line[j] = 2;
								}
								return true;
							}
							if(((JLabel)label_arr.get(j)).getIcon() != null) {
								arr.clear();
								break;
							}
						}
					}
					p1++;
					f = 0;
				}
			}
		}
		//��ֱ����
		if(index%GameSize < k%GameSize) {		   //��һ���ڵڶ�����
			int i=index, p1=index+GameSize, f=0;
			while(true) {
				if(i<index_top && p1>index_bottum)
					break;
				ArrayList arr = new ArrayList();
				if(f == 0) {
					if(i>=index_top && i/GameSize>=k_top/GameSize && i/GameSize<=k_bottum/GameSize) {
						for(int t = i;t <= index;t+=GameSize) {
								arr.add(t);
								path_line[t] = 1;
							}
						path_line[i] = 4;
						for(int j = i+1;j<(i/GameSize+1)*GameSize-1;j++) {
							System.out.println("ccct");
							arr.add(j);
							path_line[j] = 0;
							if(j%GameSize == k%GameSize) {
								for(int t = 0;t < arr.size();t++) {
									path.add(arr.get(t));
								}
								if(j<k) {
									for(int t = j+GameSize;t <= k;t+=GameSize) {
										path.add(t);
										path_line[t] =1;
									}
									path_line[j] = 5;
								} else {
									for(int t = j-GameSize;t >= k;t-=GameSize) {
										path.add(t);
										path_line[t] =1;
									}
									path_line[j] = 2;
								}
								return true;
							}
							if(((JLabel)label_arr.get(j)).getIcon() != null) {
								arr.clear();
								break;
							}
						}
					}
					i-=GameSize;
					f = 1;
				} else {
					if(p1<=index_bottum && p1/GameSize>=k_top/GameSize && p1/GameSize<=k_bottum/GameSize) {
						for(int t = p1;t >= index;t-=GameSize) {
								arr.add(t);
								path_line[t] = 1;
							}
						path_line[p1] = 3;
						for(int j = p1+1;j<(p1/GameSize+1)*GameSize-1;j++) {
							System.out.println("cccb");
							arr.add(j);
							path_line[j] = 0;
							if(j%GameSize == k%GameSize) {
								for(int t = 0;t < arr.size();t++) {
									path.add(arr.get(t));
								}
								if(j<k) {
									for(int t = j+GameSize;t <= k;t+=GameSize) {
										path.add(t);
										path_line[t] =1;
									}
									path_line[j] = 5;
								} else {
									for(int t = j-GameSize;t >= k;t-=GameSize) {
										path.add(t);
										path_line[t] =1;
									}
									path_line[j] = 2;
								}
								return true;
							}
							if(((JLabel)label_arr.get(j)).getIcon() != null) {
								arr.clear();
								break;
							}
						}
					}
					p1+=GameSize;
					f = 0;
				}
			}
		} else if(index%GameSize > k%GameSize) {	   //��һ���ڵڶ����ҷ�
			int i=index, p1=index+GameSize, f=0;
			while(true) {
				if(i<index_top && p1>index_bottum)
					break;
				ArrayList arr = new ArrayList();
				if(f == 0) {
					if(i>=index_top && i/GameSize>=k_top/GameSize && i/GameSize<=k_bottum/GameSize) {
						for(int t = i;t <= index;t+=GameSize) {
							arr.add(t);
							path_line[t] = 1;
						}
						path_line[i] = 5;
						for(int j = i-1;j>i/GameSize*GameSize;j--) {
							System.out.println("dddt");
							arr.add(j);
							path_line[j] = 0;
							if(j%GameSize == k%GameSize) {
								for(int t = 0;t < arr.size();t++) {
									path.add(arr.get(t));
								}
								if(j<k) {
									for(int t = j+GameSize;t <= k;t+=GameSize) {
										path.add(t);
										path_line[t] =1;
									}
									path_line[j] = 4;
								} else {
									for(int t = j-GameSize;t >= k;t-=GameSize) {
										path.add(t);
										path_line[t] =1;
									}
									path_line[j] = 3;
								}
								return true;
							}
							if(((JLabel)label_arr.get(j)).getIcon() != null) {
								arr.clear();
								break;
							}
						}
					}
					i-=GameSize;
					f = 1;
				} else {
					if(p1<=index_bottum && p1/GameSize>=k_top/GameSize && p1/GameSize<=k_bottum/GameSize) {
						for(int t = p1;t >= index;t-=GameSize) {
							arr.add(t);
							path_line[t] = 1;
						}
						path_line[p1] = 2;
						for(int j = p1-1;j>p1/GameSize*GameSize;j--) {
							System.out.println("dddb");
							arr.add(j);
							path_line[j] = 0;
							if(j%GameSize == k%GameSize) {
								for(int t = 0;t < arr.size();t++) {
									path.add(arr.get(t));
								}
								if(j<k) {
									for(int t = j+GameSize;t <= k;t+=GameSize) {
										path.add(t);
										path_line[t] =1;
									}
									path_line[j] = 4;
								} else {
									for(int t = j-GameSize;t >= k;t-=GameSize) {
										path.add(t);
										path_line[t] =1;
									}
									path_line[j] = 3;
								}
								return true;
							}
							if(((JLabel)label_arr.get(j)).getIcon() != null) {
								arr.clear();
								break;
							}
						}
					}
					p1+=GameSize;
					f = 0;
				}
			}
		}
		
		return false;
	}
}
