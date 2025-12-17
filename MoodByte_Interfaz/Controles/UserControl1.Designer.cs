namespace Controles
{
    partial class Menu
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            menuStrip1 = new MenuStrip();
            tsmMenuAdmin = new ToolStripMenuItem();
            usuariosToolStripMenuItem = new ToolStripMenuItem();
            articulosToolStripMenuItem = new ToolStripMenuItem();
            frasesToolStripMenuItem = new ToolStripMenuItem();
            ejerciciosToolStripMenuItem = new ToolStripMenuItem();
            musicaToolStripMenuItem = new ToolStripMenuItem();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.Items.AddRange(new ToolStripItem[] { tsmMenuAdmin });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(247, 24);
            menuStrip1.TabIndex = 0;
            menuStrip1.Text = "menuStrip1";
            // 
            // tsmMenuAdmin
            // 
            tsmMenuAdmin.BackColor = Color.FromArgb(128, 128, 255);
            tsmMenuAdmin.DropDownItems.AddRange(new ToolStripItem[] { usuariosToolStripMenuItem, articulosToolStripMenuItem, frasesToolStripMenuItem, ejerciciosToolStripMenuItem, musicaToolStripMenuItem });
            tsmMenuAdmin.Name = "tsmMenuAdmin";
            tsmMenuAdmin.Size = new Size(162, 20);
            tsmMenuAdmin.Text = "Opciones de administrador";
            // 
            // usuariosToolStripMenuItem
            // 
            usuariosToolStripMenuItem.Name = "usuariosToolStripMenuItem";
            usuariosToolStripMenuItem.Size = new Size(180, 22);
            usuariosToolStripMenuItem.Text = "Usuarios";
            // 
            // articulosToolStripMenuItem
            // 
            articulosToolStripMenuItem.Name = "articulosToolStripMenuItem";
            articulosToolStripMenuItem.Size = new Size(180, 22);
            articulosToolStripMenuItem.Text = "Articulos";
            // 
            // frasesToolStripMenuItem
            // 
            frasesToolStripMenuItem.Name = "frasesToolStripMenuItem";
            frasesToolStripMenuItem.Size = new Size(180, 22);
            frasesToolStripMenuItem.Text = "Frases";
            // 
            // ejerciciosToolStripMenuItem
            // 
            ejerciciosToolStripMenuItem.Name = "ejerciciosToolStripMenuItem";
            ejerciciosToolStripMenuItem.Size = new Size(180, 22);
            ejerciciosToolStripMenuItem.Text = "Ejercicios";
            // 
            // musicaToolStripMenuItem
            // 
            musicaToolStripMenuItem.Name = "musicaToolStripMenuItem";
            musicaToolStripMenuItem.Size = new Size(180, 22);
            musicaToolStripMenuItem.Text = "Musica";
            // 
            // Menu
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            Controls.Add(menuStrip1);
            Name = "Menu";
            Size = new Size(247, 265);
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menuStrip1;
        private ToolStripMenuItem tsmMenuAdmin;
        private ToolStripMenuItem usuariosToolStripMenuItem;
        private ToolStripMenuItem articulosToolStripMenuItem;
        private ToolStripMenuItem frasesToolStripMenuItem;
        private ToolStripMenuItem ejerciciosToolStripMenuItem;
        private ToolStripMenuItem musicaToolStripMenuItem;
    }
}
