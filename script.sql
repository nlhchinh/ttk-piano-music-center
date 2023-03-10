USE [master]
GO
/****** Object:  Database [Chinh_Assignment_FA223W]    Script Date: 23/02/2023 12:11:13 SA ******/
CREATE DATABASE [Chinh_Assignment_FA223W]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Chinh_Assignment_FA223W', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Chinh_Assignment_FA223W.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Chinh_Assignment_FA223W_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Chinh_Assignment_FA223W_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Chinh_Assignment_FA223W].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET ARITHABORT OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET  MULTI_USER 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Chinh_Assignment_FA223W]
GO
/****** Object:  Table [dbo].[tblAccount]    Script Date: 23/02/2023 12:11:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblAccount](
	[userID] [nvarchar](50) NOT NULL,
	[userName] [nvarchar](50) NULL,
	[password] [varchar](max) NULL,
	[phoneNumber] [char](10) NULL,
	[email] [varchar](50) NULL,
	[role] [char](10) NULL,
 CONSTRAINT [PK_tblAccount] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblCourse]    Script Date: 23/02/2023 12:11:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblCourse](
	[courseID] [bigint] NOT NULL,
	[courseName] [nvarchar](100) NULL,
	[image] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[tuitionFee] [int] NULL,
	[startDate] [date] NULL,
	[endDate] [date] NULL,
	[category] [char](10) NULL,
	[quantity] [int] NULL,
	[status] [char](10) NULL,
 CONSTRAINT [PK_tblCourse] PRIMARY KEY CLUSTERED 
(
	[courseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 23/02/2023 12:11:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrder](
	[orderID] [int] NOT NULL,
	[userID] [nvarchar](50) NULL,
	[orderDate] [date] NULL,
	[address] [nvarchar](max) NULL,
	[note] [nvarchar](max) NULL,
	[paymentMethod] [nchar](10) NULL,
	[paymentStatus] [nchar](10) NULL,
	[total] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblOrderDetail]    Script Date: 23/02/2023 12:11:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrderDetail](
	[orderDetailID] [int] NOT NULL,
	[courseID] [bigint] NULL,
	[odetailQty] [int] NULL,
	[price] [int] NULL,
	[orderID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[orderDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tblAccount] ([userID], [userName], [password], [phoneNumber], [email], [role]) VALUES (N'SE140506', N'chinh', N'123456', N'0328802216', N'chinh@gmail.com', N'AD        ')
INSERT [dbo].[tblAccount] ([userID], [userName], [password], [phoneNumber], [email], [role]) VALUES (N'SE140507', N'thao', N'123456', N'0356253423', N'thao@gmail.com', N'US        ')
INSERT [dbo].[tblAccount] ([userID], [userName], [password], [phoneNumber], [email], [role]) VALUES (N'SE140508', N'jessica', N'123456', N'0987654321', N'jessica@gmail.com', N'US        ')
INSERT [dbo].[tblAccount] ([userID], [userName], [password], [phoneNumber], [email], [role]) VALUES (N'SE140509', N'tra', N'123456', N'0123781232', N'tra@gmail.com', N'US        ')
INSERT [dbo].[tblAccount] ([userID], [userName], [password], [phoneNumber], [email], [role]) VALUES (N'SE140510', N'mai', N'123456', N'0987123654', N'mai@gmail.com', N'US        ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (1234123, N'Guitar lesson', N'https://i.pinimg.com/564x/4a/8d/fa/4a8dfa161e969903d8b6b11c3c68b578.jpg', N'good course', 100000, CAST(N'2022-12-15' AS Date), CAST(N'2022-12-29' AS Date), N'guitar    ', 3, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9780008483616, N'Complete Guitar Lessons System - Beginner to Advanced', N'https://i.pinimg.com/564x/b7/c6/c3/b7c6c35e6516887a8f97d8593991ae4e.jpg', N'Would You Like to Eliminate Every Struggle That You Are Faced With When Starting to Play Guitar? This course is your', 4200000, CAST(N'2022-12-17' AS Date), CAST(N'2023-01-16' AS Date), N'guitar    ', 1, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9780012009813, N'The Professional Guitar Masterclass', N'https://i.pinimg.com/564x/cb/e1/ea/cbe1ea06cc309122a5da12949c568783.jpg', N'Want the very best guitar lessons on the web?  With pro instructor feedback??

I am an award-winning GIT grad, a 15+ year professional guitarist with 70k+ students, and the founder of Guitargate - sponsored by Paul Reed Smith Guitars. 

"This course will teach you how to master your fretboard, understand music theory, and most importantly, how to use these tools to craft your own unique sound."', 2200000, CAST(N'2022-12-17' AS Date), CAST(N'2023-01-17' AS Date), N'guitar    ', 3, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9780101652719, N'Read Music FAST!', N'https://i.pinimg.com/564x/63/d1/95/63d19511f1c9bbd9e67815426f87c9db.jpg', N'Sight reading is one of the hardest aspects of learning to play the piano, and it''s universally badly taught. This course uses a unique method to teach you how to read any note on the piano keyboard quickly and easily, so that you can then tackle any piano course with confidence. It will also help if you''ve already started learning piano but are struggling to read the notes', 430000, CAST(N'2022-12-17' AS Date), CAST(N'2023-01-17' AS Date), N'guitar    ', 0, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9780194030151, N'The Heavenly Piano Masterclass - Piano Improvisation Mastery', N'https://i.pinimg.com/564x/eb/11/0e/eb110e11e62362bc0a9dee3d28a8875c.jpg', N'"The Heavenly Piano Masterclass" is an inspiring piano course developed by musician and recording artist Mark Shian to help piano players take their playing to greater heights through the understanding of piano improvisation using the power and knowledge of intervals. His experience in the studio and stage has been crucial to the development of this unique piano course. The goal here was not to just make another piano course that teaches things you can''t really apply to real world situations but to really give you effective tools, skills, knowledge, and vocabulary that translates to greater expression on the piano no matter what song it is you''re playing.', 730000, CAST(N'2023-02-04' AS Date), CAST(N'2023-03-04' AS Date), N'piano     ', 12, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9780194789066, N'Basic Skills / Getting Started with Drawing', N'https://i.pinimg.com/564x/fa/52/4d/fa524d5287c285058a7452895150b7dc.jpg', N'Drawing is not a talent. It’s a skill anyone can learn. Designed for aspiring painters, graphic designers, illustrators and artists of all types, The Art & Science of Drawing series will teach you the foundation of art and design of all kinds: drawing.', 1200000, CAST(N'2023-03-03' AS Date), CAST(N'2023-04-02' AS Date), N'drawing   ', 21, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9780241357552, N'Dynamic Mark Making / Drawing with Expression & Creativity', N'https://i.pinimg.com/564x/53/97/ee/5397ee31f873b835dd3ee1b56eda70ad.jpg', N'How you draw says just as much about you as what you draw. In this course you’ll learn to bring your drawings to life with dynamic and engaging mark making. You’ll learn to truly express yourself through drawing from the most delicate of marks to lines that jump off the page with passionate intensity.', 3000000, CAST(N'2023-04-02' AS Date), CAST(N'2023-05-14' AS Date), N'drawing   ', 6, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9780425285404, N'Guitar Foundation for Beginners to Intermediate', N'https://img-c.udemycdn.com/course/480x270/2723894_4ce8_3.jpg', N'This course is for those who are enthusiastic about this subject and have a great need to learn a solid foundation, as well as those of you who have been following the subject for a while without seeing progress, and want to find the root to build. From there, the places I lacked.', 479000, CAST(N'2023-12-17' AS Date), CAST(N'2023-01-10' AS Date), N'guitar    ', 10, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9781108610469, N'Classical Guitar Essentials - The Basics', N'https://i.pinimg.com/564x/f2/8c/14/f28c1467db6a2d739341cc0de983ba62.jpg', N'If you''ve playing guitar for months or even years and struggling to take your playing to the next level, this course is definitely for you. Reading standard music notation is a must for this course, so If you can''t read it why don''t you check out my first course in this serious then come back and continue with this one.', 1049000, CAST(N'2023-12-16' AS Date), CAST(N'2023-01-11' AS Date), N'guitar    ', 5, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9781527008618, N'Guitar Lessons for the Curious Guitarist', N'https://i.pinimg.com/564x/64/bb/4c/64bb4cc7068e3baad4d24147942cde06.jpg', N'Welcome to Guitar Lessons for the Curious Guitarist! This is a complete guitar lessons course for all levels - beginner to advanced. These lessons start at the very beginning, assuming that you don''t know anything about guitar.', 1899000, CAST(N'2023-12-12' AS Date), CAST(N'2023-01-13' AS Date), N'guitar    ', 6, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9781527008625, N'Piano Fastlane - From ZERO to HERO with Piano & Keyboard', N'https://i.pinimg.com/736x/fd/92/f6/fd92f66e77b79d17871ebf9f235862d6.jpg', N'Did you ever sit in a restaurant and listened to a song or piano piece in the background that you wished to be able to play? This course makes it possible. And not within years, but WEEKS, without wasting much money, effort and time for piano lessons.', 1700000, CAST(N'2023-02-15' AS Date), CAST(N'2023-03-15' AS Date), N'piano     ', 10, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782029345936, N'Learn the piano anytime
with real teachers.', N'https://i.pinimg.com/564x/6e/4a/01/6e4a015f951921ded14ca4eac593e384.jpg', N'Build your foundation on the piano with a perfectly structured curriculum that will teach you all the skills you need to start playing beautiful music. This is your guide to musical freedom on the piano, perfect for beginners and intermediates.', 4500000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'piano     ', 1, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782093345936, N'Fingers, Frets, & Strings', N'https://i.pinimg.com/564x/7c/f0/6c/7cf06c8ab1981107adfa849ad5898b29.jpg', N'Your index finger is your first finger, middle finger is your second finger, ring finger is your third finger, and your pinky is your fourth finger. I’m sure this seems simple to you, but when you begin reading chord diagrams, scale diagrams, tabs, and sheet music, you’ll need to know which finger to use right away.', 6400000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'guitar    ', 6, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782702945936, N'Playground Sessions', N'https://i.pinimg.com/564x/c8/35/48/c83548581f15eb90409c976c1a919a9d.jpg', N'Playground Sessions is an online piano lesson site that wears its musical credentials with pride, and with legendary producer Quincy Jones credited as co-creator and jazz icon Harry Connick Jr as a tutor, that’s not surprising. They even have their own-branded MIDI keyboard available to buy for use with the software.', 2100000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'piano     ', 6, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782703945936, N'Learn How To Play Guitar', N'https://i.pinimg.com/564x/60/c5/56/60c556bbb6480f499d29ccff79d9b80f.jpg', N'Welcome to the first video in the Beginner Guitar Quick-Start Series. I receive a lot of emails from people who want to learn how to play guitar but don’t know where to start, and that’s why I’ve made this series. This series of beginner guitar lessons is for people who have always wanted to play guitar, but just haven’t done it yet.', 2700000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'guitar    ', 5, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782738245936, N'Procreate for Beginners: Digital Illustration 101', N'https://i.pinimg.com/564x/77/74/d4/7774d4ef1bcafa24273d802febd5e992.jpg', N'This definition, however, applies to all graphic arts and techniques that are characterized by an emphasis on form or shape rather than mass and colour, as in painting. ', 5100000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'drawing   ', 10, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782742350935, N'An Accelerated Piano Course for Beginners - Piano Lessons', N'https://i.pinimg.com/564x/d1/5c/d7/d15cd781f8b1479923e4ba0f9fa4c43b.jpg', N'Hi, I''m Carl and I have been a piano teacher for over thirty years. I have a degree in music, a postgraduate degree in teaching and I hold a piano diploma through the Victoria College of Music.', 1500000, CAST(N'2023-02-02' AS Date), CAST(N'2023-03-02' AS Date), N'piano     ', 1, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782760235936, N'Sketchbooking: Explore the Human Face', N'https://i.pinimg.com/564x/88/6c/2d/886c2dd9632df00ec675fdcf6d2fac92.jpg', N'Drawing as formal artistic creation might be defined as the primarily linear rendition of objects in the visible world, as well as of concepts, thoughts, attitudes, emotions, and fantasies given visual form, of symbols and even of abstract forms.', 1000000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'drawing   ', 3, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782760295936, N'WHERE DO ONLINE METHODS FIT IN THE MUSICAL JOURNEY?', N'https://i.pinimg.com/564x/c6/94/10/c69410404098c388e043e5a4cefe7591.jpg', N'Nothing is better than playing real music! 100s of detailed song tutorials will teach you how to play popular music from all eras, styles, and genres. Practice along to backing tracks and download the sheet music for every song.', 4500000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'piano     ', 12, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782763350937, N'The Ultimate Piano Chords Course - for Piano & Keyboard', N'https://i.pinimg.com/564x/80/ef/a6/80efa685bc21c1e4298cd0491f2d93c7.jpg', N'Most songs are written using chords, so if you understand how to use them properly, you''ll be able to play a vast amount of songs by just reading simple chord symbols. You don''t need to be able to read music notation in order to play great songs!', 1000000, CAST(N'2023-12-13' AS Date), CAST(N'2023-01-14' AS Date), N'piano     ', 1, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782764350936, N'Contours / Drawing with Compelling Contours & Foreshortening', N'https://i.pinimg.com/564x/ac/f4/04/acf404992f8f8724bb9a9771fdc46b24.jpg', N'In CONTOURS you’ll learn to draw complex, volumetric form using three kinds of contour lines.  First, you’ll learn to craft a detailed outside contour.  Next you’ll learn to draw inner contours and overlaps that will describe any subject with great depth.  Finally, you’ll learn to draw using cross contour lines to create the illusion of dramatic volume and deep space.  By the end of this course, you’ll understand how to combine different kinds of contour lines to dynamically draw any form.  You’ll even learn foreshortening, one of the most sought after drawing skills.', 2100000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'drawing   ', 5, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782774645936, N'
Guitar Tricks', N'https://i.pinimg.com/564x/b4/07/e0/b407e06a0ad3a656b34c1262241099e7.jpg', N'Enjoy your first month of Guitar Tricks half price using the exclusive Guitar World code GW50MONTH at checkout. Guitar Tricks features plenty of great content for beginners, but really shines when it comes to intermediate and pro players, with over 11,000 videos across the site.', 2100000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'guitar    ', 2, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9782793845936, N'The Parts Of The Guitar', N'https://i.pinimg.com/564x/59/f9/73/59f9738219ae9d0ad4352bc4fa16b201.jpg', N'Tuning Keys & Tuning Pegs: We’ve got the tuning keys, which are used to tune the strings of the guitar. Connected to the tuning keys are the tuning pegs, or string pegs, and that’s where you attach your strings to the guitar.', 7600000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'guitar    ', 4, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (9793764345936, N'Fender Play', N'https://i.pinimg.com/736x/f1/67/60/f16760087277fd26149b91b9fe1c1cdb.jpg', N'Sorted a free trial but now you want to continue getting all the benefits of Fender Play lessons beyond your trial?', 4500000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'guitar    ', 4, N'active    ')
INSERT [dbo].[tblCourse] ([courseID], [courseName], [image], [description], [tuitionFee], [startDate], [endDate], [category], [quantity], [status]) VALUES (97827603195936, N'Online piano lessons that really work', N'https://i.pinimg.com/564x/f0/e6/af/f0e6af4f7d164dd81b5bb043dd0858e7.jpg', N'From the big stage straight to your living room – you’ll get weekly live events, lessons, and personal feedback from incredible artists as they guide and support you every step of the way on your piano journey.', 2700000, CAST(N'2023-05-17' AS Date), CAST(N'2023-06-06' AS Date), N'piano     ', 2, N'active    ')
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [address], [note], [paymentMethod], [paymentStatus], [total]) VALUES (54323, N'SE140509', CAST(N'2022-12-11' AS Date), N'113/Tran Duy Hung', N'Call me :031123242', N'cash      ', N'not yet   ', 3427000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [address], [note], [paymentMethod], [paymentStatus], [total]) VALUES (54325, N'SE140507', CAST(N'2022-12-13' AS Date), N'7/2a/342/Nguyen Thi Ranh', N'(empty)', N'cash      ', N'not yet   ', 23230000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [address], [note], [paymentMethod], [paymentStatus], [total]) VALUES (54326, N'SE140508', CAST(N'2022-12-13' AS Date), N'7/2a/342/Nguyen Thi Ranh', N'(empty)', N'cash      ', N'not yet   ', 7500000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [address], [note], [paymentMethod], [paymentStatus], [total]) VALUES (54327, N'SE140509', CAST(N'2022-12-13' AS Date), N'7/2a/342/Nguyen Thi Ranh', N'(empty)', N'cash      ', N'not yet   ', 5100000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [address], [note], [paymentMethod], [paymentStatus], [total]) VALUES (54328, N'SE140507', CAST(N'2022-12-13' AS Date), N'7/2a/342/Nguyen Thi Ranh', N'hey', N'cash      ', N'not yet   ', 5360000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [address], [note], [paymentMethod], [paymentStatus], [total]) VALUES (54329, N'SE140507', CAST(N'2022-12-13' AS Date), N'22/3b/Quang Trung', N'best course', N'cash      ', N'not yet   ', 20400000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [address], [note], [paymentMethod], [paymentStatus], [total]) VALUES (54330, N'SE140508', CAST(N'2022-12-13' AS Date), N'345/12b/Phu Hoa Dong', N'let''s go', N'cash      ', N'not yet   ', 6900000)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12351, 9782793845936, 3, 7600000, 54325)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12352, 9780101652719, 1, 430000, 54325)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12353, 9782764350936, 1, 2100000, 54326)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12354, 97827603195936, 2, 2700000, 54326)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12355, 9782774645936, 1, 2100000, 54327)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12356, 9780241357552, 1, 3000000, 54327)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12357, 9782742350935, 1, 1500000, 54328)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12358, 9780101652719, 2, 430000, 54328)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12359, 9782760235936, 3, 1000000, 54328)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12360, 9782764350936, 3, 2100000, 54329)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12361, 9782029345936, 2, 4500000, 54329)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12362, 9782738245936, 1, 5100000, 54329)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12363, 9782742350935, 1, 1500000, 54330)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12364, 9782702945936, 2, 2100000, 54330)
INSERT [dbo].[tblOrderDetail] ([orderDetailID], [courseID], [odetailQty], [price], [orderID]) VALUES (12365, 9780194789066, 1, 1200000, 54330)
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD FOREIGN KEY([courseID])
REFERENCES [dbo].[tblCourse] ([courseID])
GO
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD FOREIGN KEY([orderID])
REFERENCES [dbo].[tblOrder] ([orderID])
GO
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD FOREIGN KEY([orderDetailID])
REFERENCES [dbo].[tblOrderDetail] ([orderDetailID])
GO
USE [master]
GO
ALTER DATABASE [Chinh_Assignment_FA223W] SET  READ_WRITE 
GO
